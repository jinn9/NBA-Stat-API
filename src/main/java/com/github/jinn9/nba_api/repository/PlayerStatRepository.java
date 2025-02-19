package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.entity.PlayerStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long> {
}
