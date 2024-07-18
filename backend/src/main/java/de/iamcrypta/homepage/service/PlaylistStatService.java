package de.iamcrypta.homepage.service;

import de.iamcrypta.homepage.model.PlaylistStat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaylistStatService {

    void savePlaylistStat(PlaylistStat stat);

    List<PlaylistStat> getAllPlaylistStats();
}
