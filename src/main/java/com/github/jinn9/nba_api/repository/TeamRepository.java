package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
