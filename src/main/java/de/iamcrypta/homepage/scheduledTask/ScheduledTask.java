package de.iamcrypta.homepage.scheduledTask;

import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongTemp;
import de.iamcrypta.homepage.service.SongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduledTask {

    Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Value("${spotify.playlist.url}")
    private String spotifyPlaylistUrl;

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private SongsService songsService;

    public ScheduledTask() {
    }

    public void checkForPlaylistUpdates(){
        logger.info("Start checkForPlaylistUpdates");
        // Delete all entries in temp db
        songsService.deleteAllSongsTemp();
        logger.info("Deleted all entries in song_temp db");

        // Get new playlist from spotify api
        List<PlaylistTrack> tracks = spotifyService.getPlaylistTracks(spotifyPlaylistUrl);
        logger.info("Get new playlist from spotify api");

        // Create a list of SongTemp from PlaylistTrack to put into database
        List<SongTemp> temp = songMapper.convertAllPlaylistTracksToSongTemp(tracks);
        logger.info("Create a list of SongTemp from PlaylistTrack to put into database");

        // Put all temp in db
        songsService.saveAllTemp(temp);
        logger.info("Put all temp in db");

        // Compare temp with songs to get deleted tracks and added tracks
        List<Song> deletedTracks = songsService.getAllDeletedSongs();
        logger.info("Get deleted songs");
        List<Song> addedTracks = songsService.getAllAddedSongs();
        logger.info("Get added songs");

        // Put deleted and added songs into songs_change database
        songsService.saveAllSongsChange(songMapper.convertAllSongsToSongChanges(deletedTracks, true, false));
        logger.info("Save deleted songs into songs_change db");
        songsService.saveAllSongsChange(songMapper.convertAllSongsToSongChanges(addedTracks, false, true));
        logger.info("Save added songs into songs_change db");

        // Put added songs into songs db
        List<Song> newAddedTracks = new ArrayList<>();

        // TODO: REMOVE. Problem all addedTracks have a 0 as id.
        /*
        for(Song s: addedTracks){
            newAddedTracks.add(new Song(s.getAddedBy(),
                    s.getDateAdded(),
                    s.isLocalTrack(),
                    s.getDurationMs(),
                    s.getSongName(),
                    s.getSpotifyExternalUrl(),
                    s.getSpotifySongId()));
        }
        */


        songsService.saveAllSongs(newAddedTracks);
        logger.info("Save added songs into songs db");

        // Remove deleted songs from songs db
        songsService.deleteListOfSongs(deletedTracks);
        logger.info("Delete deleted songs from songs db");
    }
}
