package de.iamcrypta.homepage.mapper;

import de.iamcrypta.homepage.dto.SooooosSongDTO;
import de.iamcrypta.homepage.model.SooooosSong;
import de.iamcrypta.homepage.model.SooooosTemp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SooooosSongMapper {
    public SooooosSongDTO convertSooooosSongToSooooosSongDto(SooooosSong song){
        return new SooooosSongDTO(song.getAddedBy(),
                song.getDateAdded(),
                song.isLocalTrack(),
                song.getDurationMs(),
                song.getSongName(),
                song.getSpotifyExternalUrl(),
                song.getSpotifySongId());
    }

    public List<SooooosSongDTO> convertAllSooooosSongToSooooosSongDto(List<SooooosSong> songs){
        List<SooooosSongDTO> dtos = new ArrayList<>();
        for(SooooosSong song: songs){
            dtos.add(convertSooooosSongToSooooosSongDto(song));
        }
        return dtos;
    }

    public SooooosSong convertSooooosSongDtoToSooooosSong(SooooosSongDTO dto){
        return new SooooosSong(dto.getAddedBy(),
                dto.getDateAdded(),
                dto.isLocalTrack(),
                dto.getDurationMs(),
                dto.getSongName(),
                dto.getSpotifyExternalUrl(),
                dto.getSpotifySongId());
    }

    public List<SooooosSong> convertAllSooooosSongDtoToSooooosSong(List<SooooosSongDTO> dtos){
        List<SooooosSong> songs = new ArrayList<>();
        for(SooooosSongDTO dto: dtos){
            songs.add(convertSooooosSongDtoToSooooosSong(dto));
        }
        return songs;
    }

    public SooooosTemp convertSooooosSongDtoToSooooosTemp(SooooosSongDTO dto){
        return new SooooosTemp(dto.getAddedBy(),
                dto.getDateAdded(),
                dto.isLocalTrack(),
                dto.getDurationMs(),
                dto.getSongName(),
                dto.getSpotifyExternalUrl(),
                dto.getSpotifySongId());
    }

    public List<SooooosTemp> convertAllSooooosSongDtoToSooooosTemp(List<SooooosSongDTO> dtos){
        List<SooooosTemp> songs = new ArrayList<>();
        for(SooooosSongDTO dto: dtos){
            songs.add(convertSooooosSongDtoToSooooosTemp(dto));
        }
        return songs;
    }
}
