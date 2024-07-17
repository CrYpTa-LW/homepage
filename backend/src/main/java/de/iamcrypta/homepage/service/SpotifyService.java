package de.iamcrypta.homepage.service;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;

import java.util.List;
import java.util.Map;

@Service
public interface SpotifyService {

    /**
     * Function that calls the spotify api and returns a playlist for given id
     * @param playlistId the spotify id of the playlist
     * @return a playlist object
     */
    Playlist getPlaylist(String playlistId);

    /**
     * Function that calls the spotify api and returns all tracks of a playlist
     * @param playlistId the spotify id of the playlist
     * @return List of playlist tracks
     */
    List<PlaylistTrack> getPlaylistTracks(String playlistId);

    /**
     * Call the spotify api and return total duration of all songs for given users. Also return total duration of all songs.
     * @param playlistId the spotify id of the playlist
     * @param users list of users for stats
     * @return a map that maps user to total duration of songs
     */
    Map<String, Integer> getPlaylistStatsForDuration(String playlistId, List<String> users);
}
