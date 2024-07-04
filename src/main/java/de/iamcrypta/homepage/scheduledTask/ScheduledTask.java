package de.iamcrypta.homepage.scheduledTask;

import de.iamcrypta.homepage.service.SongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private SongsService songsService;

    public void checkForPlaylistUpdates(){
        // Delete all entries in temp db
        songsService.deleteAllSongsTemp();


    }
}
