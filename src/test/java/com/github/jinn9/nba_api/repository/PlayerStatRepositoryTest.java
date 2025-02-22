package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.dto.PlayerStatDto;
import com.github.jinn9.nba_api.entity.Player;
import com.github.jinn9.nba_api.entity.PlayerStat;
import com.github.jinn9.nba_api.entity.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PlayerStatRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void testFindAllWithPlayerAndTeam() {
        Player p1 = new Player("Michael", "Jordan");
        Team p1team = new Team("Chicago Bulls");
        PlayerStat p1stat = new PlayerStat("1996", p1, p1team, "SG");

        em.persist(p1);
        em.persist(p1team);
        em.persist(p1stat);

        Player p2 = new Player("Allen", "Iverson");
        Team p2team = new Team("Philadelphia 76ers");
        PlayerStat p2stat1 = new PlayerStat("1998", p2, p2team, "PG");
        PlayerStat p2stat2 = new PlayerStat("2001", p2, p2team, "SG");

        em.persist(p2);
        em.persist(p2team);
        em.persist(p2stat1);
        em.persist(p2stat2);

        Player p3 = new Player("Shaquille", "O'Neal");
        Team p3team = new Team("Los Angeles Lakers");
        PlayerStat p3stat = new PlayerStat("2000", p3, p3team, "C");

        em.persist(p3);
        em.persist(p3team);
        em.persist(p3stat);

        Player p4 = new Player("Kevin", "Garnett");
        Team p4team = new Team("Minnesota Timberwolves");
        PlayerStat p4stat = new PlayerStat("1999", p4, p4team, "PF");

        em.persist(p4);
        em.persist(p4team);
        em.persist(p4stat);

        Player p5 = new Player("Steve", "Nash");
        Team p5team = new Team("Phoenix Suns");
        PlayerStat p5stat = new PlayerStat("2005", p5, p5team, "PG");

        em.persist(p5);
        em.persist(p5team);
        em.persist(p5stat);

        // case 1: no search condition
        List<PlayerStat> result = playerStatRepository.findAllWithPlayerAndTeam(new PlayerStatDto.Request());
        assertThat(result).hasSize(6);
        assertThat(result).containsExactly(p1stat, p2stat1, p2stat2, p3stat, p4stat, p5stat);

        // case 2: search by first name
        PlayerStatDto.Request params = new PlayerStatDto.Request();
        params.setFirstName("Allen");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(p2stat1, p2stat2);

        // case 3: search by last name
        params = new PlayerStatDto.Request();
        params.setLastName("Iverson");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(p2stat1, p2stat2);

        // case 4: search by team
        params = new PlayerStatDto.Request();
        params.setTeam("Philadelphia 76ers");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(p2stat1, p2stat2);

        // case 5: search by season
        params =  new PlayerStatDto.Request();
        params.setSeason("1996");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(p1stat);

        // case 6: search by position
        params =  new PlayerStatDto.Request();
        params.setPosition("PG");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(p2stat1, p5stat);

        // case 7: search with multiple params
        params =  new PlayerStatDto.Request();
        params.setFirstName("Allen");
        params.setLastName("Iverson");
        params.setPosition("PG");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(p2stat1);

        // case 8: ignore case
        params =  new PlayerStatDto.Request();
        params.setFirstName("shaquille");
        params.setLastName("o'neal");
        params.setTeam("los angeles lakers");
        params.setPosition("c");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(p3stat);

        // case 9: search with no results
        params =  new PlayerStatDto.Request();
        params.setFirstName("Allen");
        params.setLastName("Iverson");
        params.setPosition("PF");
        result = playerStatRepository.findAllWithPlayerAndTeam(params);

        assertThat(result).hasSize(0);
    }

    @Test
    public void testFindAllWithPlayerAndTeamWithPaging() {
        Player p1 = new Player("Michael", "Jordan");
        Team p1team = new Team("Chicago Bulls");
        PlayerStat p1stat = new PlayerStat("1996", p1, p1team, "SG");

        em.persist(p1);
        em.persist(p1team);
        em.persist(p1stat);

        Player p2 = new Player("Allen", "Iverson");
        Team p2team = new Team("Philadelphia 76ers");
        PlayerStat p2stat1 = new PlayerStat("1998", p2, p2team, "PG");
        PlayerStat p2stat2 = new PlayerStat("2001", p2, p2team, "SG");

        em.persist(p2);
        em.persist(p2team);
        em.persist(p2stat1);
        em.persist(p2stat2);

        Player p3 = new Player("Shaquille", "O'Neal");
        Team p3team = new Team("Los Angeles Lakers");
        PlayerStat p3stat = new PlayerStat("2000", p3, p3team, "C");

        em.persist(p3);
        em.persist(p3team);
        em.persist(p3stat);

        Player p4 = new Player("Kevin", "Garnett");
        Team p4team = new Team("Minnesota Timberwolves");
        PlayerStat p4stat = new PlayerStat("1999", p4, p4team, "PF");

        em.persist(p4);
        em.persist(p4team);
        em.persist(p4stat);

        Player p5 = new Player("Steve", "Nash");
        Team p5team = new Team("Phoenix Suns");
        PlayerStat p5stat = new PlayerStat("2005", p5, p5team, "PG");

        em.persist(p5);
        em.persist(p5team);
        em.persist(p5stat);

        PageRequest pageRequest = PageRequest.of(1, 2);
        PlayerStatDto.Request searchParams = new PlayerStatDto.Request();

        Page<PlayerStat> page = playerStatRepository.findAllWithPlayerAndTeam(searchParams, pageRequest);

        assertThat(page.getNumber()).isEqualTo(1);
        assertThat(page.getSize()).isEqualTo(2);
        assertThat(page.getContent()).containsExactly(p2stat2, p3stat);
        assertThat(page.isFirst()).isFalse();
        assertThat(page.isLast()).isFalse();
        assertThat(page.hasNext()).isTrue();
        assertThat(page.hasPrevious()).isTrue();
        assertThat(page.getTotalElements()).isEqualTo(6);
        assertThat(page.getTotalPages()).isEqualTo(3);
    }
}