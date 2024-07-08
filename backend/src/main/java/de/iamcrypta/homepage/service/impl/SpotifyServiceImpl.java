package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.service.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpotifyServiceImpl implements SpotifyService {
    private static final String clientId = "***REMOVED***";

    private static final String clientSecret = "***REMOVED***";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    public SpotifyServiceImpl() {
    }

    public static void refreshAccessToken() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Playlist getPlaylist(String playlistId) {
        // TODO: Maybe check if one hour has passed before refreshing?
        refreshAccessToken();

        // Create a playlist request
        GetPlaylistRequest getPlaylistsRequest = spotifyApi
                .getPlaylist(playlistId)
                .build();

        // Create return playlist
        Playlist playlist = null;

        try {
            playlist = getPlaylistsRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return playlist;
    }

    @Override
    public List<PlaylistTrack> getPlaylistTracks(String playlistId) {
        // TODO: Maybe check if one hour has passed before refreshing?
        refreshAccessToken();

        // Create return list
        List<PlaylistTrack> fullPlaylist = new ArrayList<>();

        // Create string for next paging url
        String next = "";

        // Create counter for offset of api call.
        int i = 0;
        do {
            // Create a playlist request
            GetPlaylistsItemsRequest getPlaylistsItemsRequest = spotifyApi
                    .getPlaylistsItems(playlistId)
                    .offset(i)
                    .build();
            try {
                // Execute request
                Paging<PlaylistTrack> playlistTrackPaging = getPlaylistsItemsRequest.execute();

                //Get items out of paging object
                PlaylistTrack[] arrayPlaylistTracks = playlistTrackPaging.getItems();

                // Convert Array to List and add to full_playlist list
                fullPlaylist.addAll(Arrays.asList(arrayPlaylistTracks));

                // Get next api url to check if null --> End of playlist
                next = playlistTrackPaging.getNext();

                // Increment the offset by 100
                i+=100;
            } catch (IOException | SpotifyWebApiException | ParseException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }while(!(next == null));

        return fullPlaylist;
    }
}
