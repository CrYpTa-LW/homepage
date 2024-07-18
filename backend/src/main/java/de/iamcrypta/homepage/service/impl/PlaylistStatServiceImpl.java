package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.model.PlaylistStat;
import de.iamcrypta.homepage.repository.PlaylistStatsRepository;
import de.iamcrypta.homepage.service.PlaylistStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistStatServiceImpl implements PlaylistStatService {

    private final PlaylistStatsRepository playlistStatsRepository;

    @Autowired
    public PlaylistStatServiceImpl(PlaylistStatsRepository playlistStatsRepository) {
        this.playlistStatsRepository = playlistStatsRepository;
    }

    @Override
    public void savePlaylistStat(PlaylistStat stat) {
        playlistStatsRepository.saveAndFlush(stat);
    }

    @Override
    public List<PlaylistStat> getAllPlaylistStats() {
        return playlistStatsRepository.findAll();
    }
}
