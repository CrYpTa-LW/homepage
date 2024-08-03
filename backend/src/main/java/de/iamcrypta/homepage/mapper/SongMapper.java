package de.iamcrypta.homepage.mapper;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.model.SongTemp;
import de.iamcrypta.homepage.util.Util;
import org.springframework.stereotype.Component;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Component
public class SongMapper {
    private Song convertSongDtoToSong(SongDTO dto) {
        return new Song(dto.getAddedBy(),
                dto.getDateAdded(),
                dto.isLocalTrack(),
                dto.getDurationMs(),
                dto.getSongName(),
                dto.getSpotifyExternalUrl(),
                dto.getSpotifySongId(),
                dto.getArtists());
    }

    public List<Song> convertAllSongDtosToSongs(List<SongDTO> dtos) {
        List<Song> songs = new ArrayList<>();
        for (SongDTO dto : dtos) {
            songs.add(convertSongDtoToSong(dto));
        }
        return songs;
    }

    private SongChangeDTO convertSongChangeToSongChangeDtos(SongChange change) {
        return new SongChangeDTO(change.getAddedBy(),
                change.getChangeOccurredAt(),
                change.getIsLocalTrack(),
                change.getDurationMs(),
                change.getSongName(),
                change.getSpotifyExternalUrl(),
                change.getSpotifySongId(),
                change.getIsDeleted(),
                change.getIsAdded(),
                change.getArtists());
    }

    public List<SongChangeDTO> convertAllSongChangesToSongChangeDtos(List<SongChange> changes) {
        List<SongChangeDTO> dtos = new ArrayList<>();
        for (SongChange change : changes) {
            dtos.add(convertSongChangeToSongChangeDtos(change));
        }
        return dtos;
    }

    private SongTemp convertPlaylistTrackToSongTemp(PlaylistTrack track) {
        return new SongTemp(track.getAddedBy().getId(),
                track.getAddedAt().toInstant().atOffset(ZoneOffset.UTC), // Convert Date to OffsetDateTime with UTC timezone
                track.getIsLocal(),
                track.getTrack().getDurationMs(),
                track.getTrack().getName(),
                track.getTrack().getExternalUrls().toString(),
                track.getTrack().getId(),
                Util.getArtistsFromPlaylistTrack(track)
        );
    }

    public List<SongTemp> convertAllPlaylistTracksToSongTemp(List<PlaylistTrack> tracks) {
        List<SongTemp> temp = new ArrayList<>();
        for (PlaylistTrack track : tracks) {
            temp.add(convertPlaylistTrackToSongTemp(track));
        }
        return temp;
    }

    public SongChange convertSongToSongChange(Song song, boolean isDeleted, boolean isAdded) {
        return new SongChange(song.getAddedBy(),
                song.isLocalTrack(),
                song.getDurationMs(),
                song.getSongName(),
                song.getSpotifyExternalUrl(),
                song.getSpotifySongId(),
                isDeleted,
                isAdded,
                song.getArtists());
    }

    /**
     * Mapper from Song to SongChanges. HAS TO BE CALLED SEPARATELY FOR LIST OF DELETED/ADDED SONGS
     *
     * @param songs     A list of songs to be converted
     * @param isDeleted IS SET FOR ALL ITEMS IN LIST
     * @param isAdded   IS SET FOR ALL ITEMS IN LIST
     * @return List of SongChanges
     */
    public List<SongChange> convertAllSongsToSongChanges(List<Song> songs, boolean isDeleted, boolean isAdded) {
        List<SongChange> changes = new ArrayList<>();
        for (Song song : songs) {
            changes.add(convertSongToSongChange(song, isDeleted, isAdded));
        }
        return changes;
    }
}
