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

    private String season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String position;
    private int age;
    private int experience;
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

    public PlayerStat(String season, Player player, Team team, String position, int age, int experience, int gp, int gs,
                      int mp, int fg, int fga, double fgPercent, int x3p, int x3pa, double x3pPercent, int x2p,
                      int x2pa, double x2pPercent, double eFgPercent, int ft, int fta, double ftPercent, int orb,
                      int drb, int trb, int ast, int stl, int blk, int tov, int pf, int pts) {
        this.season = season;
        this.player = player;
        this.team = team;
        this.position = position;
        this.age = age;
        this.experience = experience;
        this.gp = gp;
        this.gs = gs;
        this.mp = mp;
        this.fg = fg;
        this.fga = fga;
        this.fgPercent = fgPercent;
        this.x3p = x3p;
        this.x3pa = x3pa;
        this.x3pPercent = x3pPercent;
        this.x2p = x2p;
        this.x2pa = x2pa;
        this.x2pPercent = x2pPercent;
        this.eFgPercent = eFgPercent;
        this.ft = ft;
        this.fta = fta;
        this.ftPercent = ftPercent;
        this.orb = orb;
        this.drb = drb;
        this.trb = trb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.tov = tov;
        this.pf = pf;
        this.pts = pts;
    }
}
