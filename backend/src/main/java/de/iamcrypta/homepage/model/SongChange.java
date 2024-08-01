package de.iamcrypta.homepage.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "songs_change")
public class SongChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "added_by", nullable = false)
    private String addedBy;

    @Column(name = "change_occurred_at", nullable = false)
    private Date changeOccurredAt;

    @Column(name = "is_local_track", nullable = false)
    private boolean isLocalTrack;

    @Column(name = "duration_ms", nullable = false)
    private int durationMs;

    @Column(name = "song_name", nullable = false)
    private String songName;

    @Column(name = "spotify_external_url", nullable = false)
    private String spotifyExternalUrl;

    @Column(name = "spotify_song_id", nullable = false)
    private String spotifySongId;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "is_added", nullable = false)
    private boolean isAdded;

    @Column(name = "artists")
    private String artists;

    public SongChange() {
    }

    public SongChange(String addedBy, boolean isLocalTrack, int durationMs, String songName, String spotifyExternalUrl, String spotifySongId, boolean isDeleted, boolean isAdded, String artists) {
        if (isLocalTrack) {
            this.spotifySongId = "";
        } else {
            this.spotifySongId = spotifySongId;
        }
        this.addedBy = addedBy;
        // TODO: change to one day before
        this.changeOccurredAt = new Date();
        this.isLocalTrack = isLocalTrack;
        this.durationMs = durationMs;
        this.songName = songName;
        this.spotifyExternalUrl = spotifyExternalUrl;
        this.isDeleted = isDeleted;
        this.isAdded = isAdded;
        this.artists = artists;
    }

    public Long getId() {
        return id;
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

    public boolean getIsLocalTrack() {
        return isLocalTrack;
    }

    public void setIsLocalTrack(boolean localTrack) {
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

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean getIsAdded() {
        return isAdded;
    }

    public void setIsAdded(boolean added) {
        isAdded = added;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "SongChange{" +
                "id=" + id +
                ", addedBy='" + addedBy + '\'' +
                ", changeOccurredAt=" + changeOccurredAt +
                ", isLocalTrack=" + isLocalTrack +
                ", durationMs=" + durationMs +
                ", songName='" + songName + '\'' +
                ", spotifyExternalUrl='" + spotifyExternalUrl + '\'' +
                ", spotifySongId='" + spotifySongId + '\'' +
                ", isDeleted=" + isDeleted +
                ", isAdded=" + isAdded +
                ", artists='" + artists + '\'' +
                '}';
    }
}
