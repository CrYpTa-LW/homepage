package de.iamcrypta.homepage.scheduledTask;

import de.iamcrypta.homepage.service.SooooosSongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;

import java.util.List;

@Service
public class sooooosScheduledTask {

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private SooooosSongsService sooooosSongsService;

    public void checkForPlaylistUpdates(){
        // Delete all entries in temp db
        sooooosSongsService.deleteAllSongsTemp();


    }
}
