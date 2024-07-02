package de.iamcrypta.homepage.service;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;

import java.util.List;

@Service
public interface SpotifyService {

    /**
     * Funkcion that calls the spotify api and returns a playlist for given id
     * @param playlistId
     * @return a playlist object
     */
    public Playlist getPlaylist(String playlistId);

    /**
     * Function that calls the spotify api and returns all tracks of a playlist
     * @param playlistId
     * @return
     */
    public List<PlaylistTrack> getPlaylistTracks(String playlistId);
}
