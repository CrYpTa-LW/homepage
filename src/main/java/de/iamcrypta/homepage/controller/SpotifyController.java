package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SooooosSongChangeDTO;
import de.iamcrypta.homepage.dto.SooooosSongDTO;
import de.iamcrypta.homepage.mapper.SooooosSongMapper;
import de.iamcrypta.homepage.model.SooooosSongChange;
import de.iamcrypta.homepage.repository.SooooosSongsChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api")
public class SpotifyController {

    @Autowired
    SooooosSongsChangeRepository sooooosSongsChangeRepository;

    @Autowired
    SooooosSongMapper sooooosSongMapper;

    @GetMapping(path = "/getSooooosSongChange")
    public List<SooooosSongChangeDTO> getSooooosSongChange(){
        List<SooooosSongChange> sooooosSongChanges= sooooosSongsChangeRepository.findAll();
        return sooooosSongMapper.convertAllSooooosSongChangeToSoooooSongChangeDto(sooooosSongChanges);
    }
}
