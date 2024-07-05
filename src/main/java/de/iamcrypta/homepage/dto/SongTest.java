package de.iamcrypta.homepage.dto;

import java.time.OffsetDateTime;

public interface SongTest {

    public String getAddedBy();

    public OffsetDateTime getDateAdded() ;

    public boolean isLocalTrack();

    public int getDurationMs();

    public String getSongName();

    public String getSpotifyExternalUrl();

    public String getSpotifySongId();
}
