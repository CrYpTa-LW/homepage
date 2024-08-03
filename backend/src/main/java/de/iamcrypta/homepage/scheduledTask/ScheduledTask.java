package de.iamcrypta.homepage.scheduledTask;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongTemp;
import de.iamcrypta.homepage.service.SongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import de.iamcrypta.homepage.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;

import java.util.List;

@Service
public class ScheduledTask {

    Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Value("${spotify.playlist.url}")
    private String spotifyPlaylistUrl;

    private final SpotifyService spotifyService;

    private final SongMapper songMapper;

    private final SongsService songsService;

    @Autowired
    public ScheduledTask(SpotifyService spotifyService, SongMapper songMapper, SongsService songsService) {
        this.spotifyService = spotifyService;
        this.songMapper = songMapper;
        this.songsService = songsService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void checkForPlaylistUpdates(){
        logger.info("Start checkForPlaylistUpdates");
        // Delete all entries in temp db
        songsService.deleteAllSongsTemp();
        logger.info("Deleted all entries in song_temp db");

        // Get new playlist from spotify api
        List<PlaylistTrack> tracks = spotifyService.getPlaylistTracks(spotifyPlaylistUrl);
        logger.info("Got new playlist from spotify api");

        // Create a list of SongTemp from PlaylistTrack to put into database
        List<SongTemp> tempWithWrongNames = songMapper.convertAllPlaylistTracksToSongTemp(tracks);
        logger.info("Created a list of SongTemp from PlaylistTrack to put into database");

        // Convert the spotify id to proper names
        List<SongTemp> temp = Util.fixSongAddedByNames(tempWithWrongNames);

        // Put all temp in db
        songsService.saveAllTemp(temp);
        logger.info("Put all temp in db");

        // Compare temp with songs to get deleted tracks and added tracks
        List<SongDTO> deletedTracksDTO = songsService.getAllDeletedSongs();
        List<Song> deletedTracks = songMapper.convertAllSongDtosToSongs(deletedTracksDTO);
        logger.info("Got deleted songs");
        List<SongDTO> addedTracksDTO = songsService.getAllAddedSongs();
        List<Song> addedTracks = songMapper.convertAllSongDtosToSongs(addedTracksDTO);
        logger.info("Got added songs");

        // Put deleted and added songs into songs_change database
        songsService.saveAllSongsChange(songMapper.convertAllSongsToSongChanges(deletedTracks, true, false));
        logger.info("Saved deleted songs into songs_change db");
        songsService.saveAllSongsChange(songMapper.convertAllSongsToSongChanges(addedTracks, false, true));
        logger.info("Saved added songs into songs_change db");

        // Add added songs into song db
        songsService.saveAllSongs(addedTracks);
        logger.info("Saved added songs into songs db");

        // Remove deleted songs from songs db
        songsService.deleteListOfSongs(deletedTracks);
        logger.info("Deleted deleted songs from songs db");
    }
}
