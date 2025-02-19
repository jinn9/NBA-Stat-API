package com.github.jinn9.nba_api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class PlayerStat {

    @Id @GeneratedValue
    @Column(name = "player_stat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String season;
    private int gp;
    private int gs;
    private int mp;
    private int fg;
    private int fga;
    private double fgPercent;
    private int x3p;
    private int x3pa;
    private double x3pPercent;
    private int x2p;
    private int x2pa;
    private double x2pPercent;
    private double eFgPercent;
    private int ft;
    private int fta;
    private double ftPercent;
    private int orb;
    private int drb;
    private int trb;
    private int ast;
    private int stl;
    private int blk;
    private int tov;
    private int pf;
    private int pts;
}
