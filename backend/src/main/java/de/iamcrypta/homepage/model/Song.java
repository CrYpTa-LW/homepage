package de.iamcrypta.homepage.model;

import de.iamcrypta.homepage.dto.SongDTO;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@NamedNativeQuery(name = "Song.findSongsNotInTemp",
                query = "SELECT s.added_by as addedBy,s.date_added as dateAdded, s.is_local_track as isLocalTrack, s.duration_ms as durationMs, s.song_name as songName, s.spotify_external_url as spotifyExternalUrl, s.spotify_song_id as spotifySongId FROM songs s EXCEPT SELECT st.added_by,st.date_added, st.is_local_track, st.duration_ms, st.song_name, st.spotify_external_url, st.spotify_song_id FROM songs_temp st",
                resultSetMapping = "Mapping.SongDTO")

@NamedNativeQuery(name = "Song.findTempNotInSongs",
                query = "SELECT st.added_by as addedBy,st.date_added as dateAdded, st.is_local_track as isLocalTrack, st.duration_ms as durationMs, st.song_name as songName, st.spotify_external_url as spotifyExternalUrl, st.spotify_song_id as spotifySongId FROM songs_temp st EXCEPT SELECT s.added_by,s.date_added, s.is_local_track, s.duration_ms, s.song_name, s.spotify_external_url, s.spotify_song_id FROM songs s",
                resultSetMapping = "Mapping.SongDTO")

@SqlResultSetMapping(name = "Mapping.SongDTO",
                    classes = @ConstructorResult(targetClass = SongDTO.class,
                              columns = {@ColumnResult(name = "addedBy"),
                                         @ColumnResult(name = "dateAdded", type = java.time.OffsetDateTime.class),
                                         @ColumnResult(name = "isLocalTrack"),
                                         @ColumnResult(name = "durationMs", type = Integer.class),
                                         @ColumnResult(name = "songName"),
                                         @ColumnResult(name = "spotifyExternalUrl"),
                                         @ColumnResult(name = "spotifySongId")}))

@Entity
@Table(name = "songs")
public class Song {

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

    @Column(name="artists")
    private String artists;

    public Song() {
    }

    public Song(String addedBy, OffsetDateTime dateAdded, boolean isLocalTrack, int durationMs, String songName, String spotifyExternalUrl, String spotifySongId, String artists) {
        if(isLocalTrack){
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

    public void setId(Long id){
        this.id = id;
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

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return "Song{" +
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
