package com.github.jinn9.nba_api.config;

import com.github.jinn9.nba_api.entity.Player;
import com.github.jinn9.nba_api.entity.PlayerStat;
import com.github.jinn9.nba_api.entity.Team;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Profile("local")
@RequiredArgsConstructor
@Component
public class InitSampleData {

    private final InitSampleDataService initSampleDataService;

    @PostConstruct
    public void init() {
        initSampleDataService.init();
    }

    @Component
    @RequiredArgsConstructor
    public static class InitSampleDataService {

        private final EntityManager em;

        @Transactional
        public void init() {
            Player player1 = new Player("Michael", "Jordan", "SF", 78, 198,
                    "UNC", LocalDate.of(1963, 2, 17));
            em.persist(player1);

            Team team1 = new Team("Chicago Bulls");
            em.persist(team1);

            PlayerStat stat1 = new PlayerStat(1996, player1, team1, "SG", 32,
                    11, 82, 82, 3090, 916, 1850, 0.495, 111, 260,
                    0.427, 805, 1590, 0.506, 0.525, 548, 657,
                    0.834, 148, 395, 543, 352, 180, 42, 197, 195, 2491);
            em.persist(stat1);


            Player player2 = new Player("Allen", "Iverson", "G", 72, 165,
                    "Georgetown",LocalDate.of(1975, 6, 7));
            em.persist(player2);

            Team team2 = new Team("Philadelphia 76ers");
            em.persist(team2);

            PlayerStat stat2 = new PlayerStat(2001, player2, team2, "SG", 25, 5, 71,
                    71, 2979, 762, 1813, 0.42, 98, 306, 0.32, 664,
                    1507, 0.441, 0.447, 585, 719, 0.814, 50, 223,
                    273, 325, 178, 20, 237, 147, 2207);
            em.persist(stat2);

            Player player3 = new Player("Shaquille", "O'Neal", "C", 85, 325,
                    "LSU", LocalDate.of(1972, 3, 6));
            em.persist(player3);

            Team team3 = new Team("Los Angeles Lakers");
            em.persist(team3);

            PlayerStat stat3 = new PlayerStat(2000, player3, team3, "C", 27, 8, 79,
                    79, 3163, 956, 1665, 0.574, 0, 1, 0, 956, 1664,
                    0.575, 0.574, 432, 824, 0.524, 336, 742, 1078,
                    299, 36, 239, 223, 255, 2344);
            em.persist(stat3);

            Player player4 = new Player("Kevin", "Garnett", "F-C", 83, 240,
                    "NA", LocalDate.of(1976, 5, 19));
            em.persist(player4);

            Team team4 = new Team("Minnesota Timberwolves");
            em.persist(team4);

            PlayerStat stat4 = new PlayerStat(1999, player4, team4, "PF", 22, 4, 47,
                    47, 1780, 414, 900, 0.46, 4, 14, 0.286, 410,
                    886, 0.463, 0.462, 145, 206, 0.704, 166, 323,
                    489, 202, 78, 83, 135, 152, 977);
            em.persist(stat4);

            Player player5 = new Player("Steve", "Nash", "G", 75, 195,
                    "Santa Clara", LocalDate.of(1974, 2, 7));
            em.persist(player5);

            Team team5 = new Team("Phoenix Suns");
            em.persist(team5);

            PlayerStat stat5 = new PlayerStat(2005, player5, team5, "PG", 30, 9, 75,
                    75, 2573, 430, 857, 0.502, 94, 218, 0.431, 336,
                    639, 0.526, 0.557, 211, 238, 0.887, 57, 192,
                    249, 861, 74, 6, 245, 136, 1165);
            em.persist(stat5);

        }

    }
}
