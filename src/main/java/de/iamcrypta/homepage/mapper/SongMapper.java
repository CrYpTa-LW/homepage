package de.iamcrypta.homepage.mapper;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.model.SongTemp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongMapper {
    public SongDTO convertSongToSongDto(Song song){
        return new SongDTO(song.getAddedBy(),
                song.getDateAdded(),
                song.isLocalTrack(),
                song.getDurationMs(),
                song.getSongName(),
                song.getSpotifyExternalUrl(),
                song.getSpotifySongId());
    }

    public List<SongDTO> convertAllSongsToSongDtos(List<Song> songs){
        List<SongDTO> dtos = new ArrayList<>();
        for(Song song: songs){
            dtos.add(convertSongToSongDto(song));
        }
        return dtos;
    }

    public Song convertSongDtoToSong(SongDTO dto){
        return new Song(dto.getAddedBy(),
                dto.getDateAdded(),
                dto.isLocalTrack(),
                dto.getDurationMs(),
                dto.getSongName(),
                dto.getSpotifyExternalUrl(),
                dto.getSpotifySongId());
    }

    public List<Song> convertAllSongDtosToSongs(List<SongDTO> dtos){
        List<Song> songs = new ArrayList<>();
        for(SongDTO dto: dtos){
            songs.add(convertSongDtoToSong(dto));
        }
        return songs;
    }

    public SongTemp convertSongDtoToSongTemp(SongDTO dto){
        return new SongTemp(dto.getAddedBy(),
                dto.getDateAdded(),
                dto.isLocalTrack(),
                dto.getDurationMs(),
                dto.getSongName(),
                dto.getSpotifyExternalUrl(),
                dto.getSpotifySongId());
    }

    public List<SongTemp> convertAllSongDtosToSongTemp(List<SongDTO> dtos){
        List<SongTemp> songs = new ArrayList<>();
        for(SongDTO dto: dtos){
            songs.add(convertSongDtoToSongTemp(dto));
        }
        return songs;
    }

    public SongChangeDTO convertSongChangeToSongChangeDtos(SongChange change){
        return new SongChangeDTO(change.getAddedBy(),
                                        change.getChangeOccurredAt(),
                                        change.getIsLocalTrack(),
                                        change.getDurationMs(),
                                        change.getSongName(),
                                        change.getSpotifyExternalUrl(),
                                        change.getSpotifySongId(),
                                        change.getIsDeleted(),
                                        change.getIsAdded()
                                        );
    }

    public List<SongChangeDTO> convertAllSongChangesToSongChangeDtos(List<SongChange> changes){
        List<SongChangeDTO> dtos = new ArrayList<>();
        for(SongChange change: changes){
            dtos.add(convertSongChangeToSongChangeDtos(change));
        }
        return dtos;
    }
}
