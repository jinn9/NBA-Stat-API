package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.dto.PlayerStatDto;
import com.github.jinn9.nba_api.entity.PlayerStat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerStatRepositoryCustom {
    List<PlayerStat> findAllWithPlayerAndTeam(PlayerStatDto.Request params);
    Page<PlayerStat> findAllWithPlayerAndTeam(PlayerStatDto.Request params, Pageable pageable);
}
