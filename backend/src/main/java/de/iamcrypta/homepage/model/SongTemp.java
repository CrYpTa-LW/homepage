package de.iamcrypta.homepage.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "songs_temp")
public class SongTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "added_by", nullable = false)
    private String addedBy;

    @Column(name = "date_added", nullable = false)
    private OffsetDateTime dateAdded;

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

    @Column(name = "artists")
    private String artists;

    public SongTemp() {
    }

    public SongTemp(String addedBy, OffsetDateTime dateAdded, boolean isLocalTrack, int durationMs, String songName, String spotifyExternalUrl, String spotifySongId, String artists) {
        if (isLocalTrack) {
            this.spotifySongId = "";
        } else {
            this.spotifySongId = spotifySongId;
        }
        this.addedBy = addedBy;
        this.dateAdded = dateAdded;
        this.isLocalTrack = isLocalTrack;
        this.durationMs = durationMs;
        this.songName = songName;
        this.spotifyExternalUrl = spotifyExternalUrl;
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

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "SongTemp{" +
                "id=" + id +
                ", addedBy='" + addedBy + '\'' +
                ", dateAdded=" + dateAdded +
                ", isLocalTrack=" + isLocalTrack +
                ", durationMs=" + durationMs +
                ", songName='" + songName + '\'' +
                ", spotifyExternalUrl='" + spotifyExternalUrl + '\'' +
                ", spotifySongId='" + spotifySongId + '\'' +
                ", artists='" + artists + '\'' +
                '}';
    }
}
