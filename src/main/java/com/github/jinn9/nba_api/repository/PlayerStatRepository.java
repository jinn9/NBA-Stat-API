package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.entity.PlayerStat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long>, PlayerStatRepositoryCustom {

    @Query("select ps from PlayerStat ps")
    @EntityGraph(attributePaths = {"player", "team"})
    List<PlayerStat> findAllWithPlayerAndTeam();
}
