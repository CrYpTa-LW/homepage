package de.iamcrypta.homepage.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

public class SooooosSongDTO {

    private String addedBy;
    private OffsetDateTime dateAdded;
    private boolean isLocalTrack;
    private int durationMs;
    private String songName;
    private String spotifyExternalUrl;
    private String spotifySongId;

    public SooooosSongDTO(String addedBy, OffsetDateTime dateAdded, boolean isLocalTrack, int durationMs, String songName, String spotifyExternalUrl, String spotifySongId) {
        this.addedBy = addedBy;
        this.dateAdded = dateAdded;
        this.isLocalTrack = isLocalTrack;
        this.durationMs = durationMs;
        this.songName = songName;
        this.spotifyExternalUrl = spotifyExternalUrl;
        this.spotifySongId = spotifySongId;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public OffsetDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(OffsetDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isLocalTrack() {
        return isLocalTrack;
    }

    public void setLocalTrack(boolean localTrack) {
        isLocalTrack = localTrack;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSpotifyExternalUrl() {
        return spotifyExternalUrl;
    }

    public void setSpotifyExternalUrl(String spotifyExternalUrl) {
        this.spotifyExternalUrl = spotifyExternalUrl;
    }

    public String getSpotifySongId() {
        return spotifySongId;
    }

    public void setSpotifySongId(String spotifySongId) {
        this.spotifySongId = spotifySongId;
    }

    @Override
    public String toString() {
        return "SooooosSongs{" +
                "addedBy='" + addedBy + '\'' +
                ", dateAdded=" + dateAdded +
                ", isLocalTrack=" + isLocalTrack +
                ", durationMs=" + durationMs +
                ", songName='" + songName + '\'' +
                ", spotifyExternalUrl='" + spotifyExternalUrl + '\'' +
                ", spotifySongId='" + spotifySongId + '\'' +
                '}';
    }
}
