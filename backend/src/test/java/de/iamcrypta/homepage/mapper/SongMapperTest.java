package de.iamcrypta.homepage.mapper;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.model.SongTemp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.michaelthelin.spotify.model_objects.specification.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SuppressWarnings("ExtractMethodRecommender")
class SongMapperTest {

    private SongMapper songMapper;

    @BeforeEach
    void setUp() {
        songMapper = new SongMapper();
    }

    /**
     * Test normal mapping. Important: If a Song or DTO is a local track --> No spotifyID
     */
    @Test
    void convertAllSongDtosToSongs() {
        SongDTO songDto1 = new SongDTO("Leon",
                OffsetDateTime.of(2010,1,1,0,0,0,0, ZoneOffset.of("Z")),
                false,
                10000,
                "Red Flag",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=8de4b91eff544e25",
                "2fa45195dc9e4aed",
                "Billy Talent");

        SongDTO songDto2 = new SongDTO("Finn",
                OffsetDateTime.of(2010,12,12,0,0,0,0, ZoneOffset.of("Z")),
                true,
                585858,
                "Hello World",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=8de4bdwdwd3434",
                "8de4bdwdwd3434",
                "Super Duper");

        List<SongDTO> songDtos = new ArrayList<>();
        songDtos.add(songDto1);
        songDtos.add(songDto2);

        List<Song> songs = songMapper.convertAllSongDtosToSongs(songDtos);

        for(int i = 0; i < songs.size(); i++){
            SongDTO dto = songDtos.get(i);
            Song song = songs.get(i);

            assertEquals(dto.getSongName(), song.getSongName());
            assertEquals(dto.getAddedBy(), song.getAddedBy());
            assertEquals(dto.getArtists(), song.getArtists());
            assertEquals(dto.getSpotifyExternalUrl(), song.getSpotifyExternalUrl());
            assertEquals(dto.getDateAdded(), song.getDateAdded());
            assertEquals(dto.getDurationMs(), song.getDurationMs());
            assertEquals(dto.isLocalTrack(), song.isLocalTrack());
            if(dto.isLocalTrack()){
                assertEquals("", song.getSpotifySongId());
            } else {
                assertEquals(dto.getSpotifySongId(), song.getSpotifySongId());
            }
        }
    }

    /**
     * Test normal mapping. Important: If a SongChange or SongChangeDTO is a local track --> No spotifyID
     */
    @Test
    void convertAllSongChangesToSongChangeDtos() {
        SongChange songChange1 = new SongChange("Leon",
                false,
                1000,
                "Red Flag",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=8de4b91eff544e25",
                "8de4b91eff544e25",
                true,
                false,
                "Billy Talent");

        SongChange songChange2 = new SongChange("Finn",
                true,
                58455489,
                "Hello World",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=5757t555h",
                "5757t555h",
                false,
                true,
                "Super Duper");

        List<SongChange> songChanges = new ArrayList<>();
        songChanges.add(songChange1);
        songChanges.add(songChange2);

        List<SongChangeDTO> songChangeDTOS = songMapper.convertAllSongChangesToSongChangeDtos(songChanges);

        for(int i = 0; i < songChanges.size(); i++){
            SongChange songChange = songChanges.get(i);
            SongChangeDTO songChangeDTO = songChangeDTOS.get(i);

            assertEquals(songChange.getAddedBy(), songChangeDTO.getAddedBy());
            assertEquals(songChange.getChangeOccurredAt(), songChangeDTO.getChangeOccurredAt());
            assertEquals(songChange.getIsLocalTrack(), songChangeDTO.isLocalTrack());
            assertEquals(songChange.getDurationMs(), songChangeDTO.getDurationMs());
            assertEquals(songChange.getSongName(), songChangeDTO.getSongName());
            assertEquals(songChange.getSpotifyExternalUrl(), songChangeDTO.getSpotifyExternalUrl());
            assertEquals(songChange.getIsAdded(), songChangeDTO.isAdded());
            assertEquals(songChange.getIsDeleted(), songChangeDTO.isDeleted());
            assertEquals(songChange.getArtists(), songChangeDTO.getArtists());

            if(songChange.getIsLocalTrack()){
                assertEquals("", songChangeDTO.getSpotifySongId());
            } else {
                assertEquals(songChange.getSpotifySongId(), songChangeDTO.getSpotifySongId());
            }
        }
    }


    /**
     * Test normal mapping. Important: If a PlaylistTrack is a local track --> No spotifyID
     */
    @Test
    void convertAllPlaylistTracksToSongTemp() {

        Map<String, String> map = new HashMap<>();
        map.put("Hello", "World");

        PlaylistTrack track1 = new PlaylistTrack.Builder()
                .setAddedBy(new User.Builder().setId("123").build())
                .setAddedAt(new Date())
                .setIsLocal(true)
                .setTrack(new Track.Builder()
                        .setDurationMs(10000)
                        .setName("Red Flag")
                        .setId("555")
                        .setExternalUrls(new ExternalUrl.Builder().setExternalUrls(map).build())
                        .setArtists(new ArtistSimplified.Builder().setName("Billy Talent").build())
                        .build())
                .build();

        PlaylistTrack track2 = new PlaylistTrack.Builder()
                .setAddedBy(new User.Builder().setId("4546").build())
                .setAddedAt(new Date())
                .setIsLocal(true)
                .setTrack(new Track.Builder()
                        .setDurationMs(2658)
                        .setName("Hello World")
                        .setId("577")
                        .setExternalUrls(new ExternalUrl.Builder().setExternalUrls(map).build())
                        .setArtists(new ArtistSimplified.Builder().setName("Super Duper").build())
                        .build())
                .build();

        List<PlaylistTrack> playlistTracks = new ArrayList<>();
        playlistTracks.add(track1);
        playlistTracks.add(track2);

        List<SongTemp> songTemps = songMapper.convertAllPlaylistTracksToSongTemp(playlistTracks);

        for(int i = 0; i<songTemps.size(); i++){
            SongTemp songTemp = songTemps.get(i);
            PlaylistTrack playlistTrack = playlistTracks.get(i);

            assertEquals(playlistTrack.getAddedBy().getId(), songTemp.getAddedBy());
            //assertEquals(playlistTrack.getAddedAt(), songTemp.getDateAdded());
            assertEquals(playlistTrack.getIsLocal(), songTemp.isLocalTrack());
            assertEquals(playlistTrack.getTrack().getDurationMs(), songTemp.getDurationMs());
            assertEquals(playlistTrack.getTrack().getName(), songTemp.getSongName());
            assertEquals(playlistTrack.getTrack().getExternalUrls().toString(), songTemp.getSpotifyExternalUrl());

            if(playlistTrack.getIsLocal()){
                assertEquals("", songTemp.getSpotifySongId());
            } else {
                assertEquals(playlistTrack.getTrack().getId(), songTemp.getSpotifySongId());
            }

        }
    }

    @Test
    void convertAllSongsToSongChanges() {
        Song song1 = new Song("Leon",
                OffsetDateTime.of(2010,1,1,0,0,0,0, ZoneOffset.of("Z")),
                false,
                10000,
                "Red Flag",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=8de4b91eff544e25",
                "2fa45195dc9e4aed",
                "Billy Talent");

        Song song2 = new Song("Finn",
                OffsetDateTime.of(2010,12,12,0,0,0,0, ZoneOffset.of("Z")),
                true,
                585858,
                "Hello World",
                "https://open.spotify.com/intl-de/track/2RZWdE8kYPlCAcRUYDeuLC?si=8de4bdwdwd3434",
                "8de4bdwdwd3434",
                "Super Duper");

        List<SongChange> songChange1 = songMapper.convertAllSongsToSongChanges(List.of(song1), true, false);
        List<SongChange> songChange2 = songMapper.convertAllSongsToSongChanges(List.of(song2), false, true);

        assertEquals(song1.getAddedBy(), songChange1.get(0).getAddedBy());
        assertEquals(song1.isLocalTrack(), songChange1.get(0).getIsLocalTrack());
        assertEquals(song1.getDurationMs(), songChange1.get(0).getDurationMs());
        assertEquals(song1.getSongName(), songChange1.get(0).getSongName());
        assertEquals(song1.getSpotifyExternalUrl(), songChange1.get(0).getSpotifyExternalUrl());
        assertTrue(songChange1.get(0).getIsDeleted());
        assertFalse(songChange1.get(0).getIsAdded());

        if(songChange1.get(0).getIsLocalTrack()){
            assertEquals("", songChange1.get(0).getSpotifySongId());
        } else {
            assertEquals(song1.getSpotifySongId(), songChange1.get(0).getSpotifySongId());
        }

        assertEquals(song2.getAddedBy(), songChange2.get(0).getAddedBy());
        assertEquals(song2.isLocalTrack(), songChange2.get(0).getIsLocalTrack());
        assertEquals(song2.getDurationMs(), songChange2.get(0).getDurationMs());
        assertEquals(song2.getSongName(), songChange2.get(0).getSongName());
        assertEquals(song2.getSpotifyExternalUrl(), songChange2.get(0).getSpotifyExternalUrl());
        assertFalse(songChange2.get(0).getIsDeleted());
        assertTrue(songChange2.get(0).getIsAdded());

        if(songChange2.get(0).getIsLocalTrack()){
            assertEquals("", songChange2.get(0).getSpotifySongId());
        } else {
            assertEquals(song2.getSpotifySongId(), songChange2.get(0).getSpotifySongId());
        }
    }
}