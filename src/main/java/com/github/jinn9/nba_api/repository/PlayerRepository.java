package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
