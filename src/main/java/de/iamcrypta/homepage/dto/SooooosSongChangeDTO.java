package de.iamcrypta.homepage.dto;

import java.time.OffsetDateTime;
import java.util.Date;

public class SooooosSongChangeDTO {

    private String addedBy;
    private Date changeOccurredAt;
    private boolean isLocalTrack;
    private int durationMs;
    private String songName;
    private String spotifyExternalUrl;
    private String spotifySongId;
    private boolean isDeleted;
    private boolean isAdded;

    public SooooosSongChangeDTO(String addedBy, Date changeOccurredAt, boolean isLocalTrack, int durationMs, String songName, String spotifyExternalUrl, String spotifySongId, boolean isDeleted, boolean isAdded) {
        this.addedBy = addedBy;
        this.changeOccurredAt = changeOccurredAt;
        this.isLocalTrack = isLocalTrack;
        this.durationMs = durationMs;
        this.songName = songName;
        this.spotifyExternalUrl = spotifyExternalUrl;
        this.spotifySongId = spotifySongId;
        this.isDeleted = isDeleted;
        this.isAdded = isAdded;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getChangeOccurredAt() {
        return changeOccurredAt;
    }

    public void setChangeOccurredAt(Date changeOccurredAt) {
        this.changeOccurredAt = changeOccurredAt;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    @Override
    public String toString() {
        return "SooooosSongChangeDTO{" +
                "addedBy='" + addedBy + '\'' +
                ", changeOccurredAt=" + changeOccurredAt +
                ", isLocalTrack=" + isLocalTrack +
                ", durationMs=" + durationMs +
                ", songName='" + songName + '\'' +
                ", spotifyExternalUrl='" + spotifyExternalUrl + '\'' +
                ", spotifySongId='" + spotifySongId + '\'' +
                ", isDeleted=" + isDeleted +
                ", isAdded=" + isAdded +
                '}';
    }
}
