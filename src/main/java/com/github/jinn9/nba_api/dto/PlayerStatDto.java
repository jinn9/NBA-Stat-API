package com.github.jinn9.nba_api.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.jinn9.nba_api.entity.PlayerStat;
import lombok.Data;

public class PlayerStatDto {

        @Data
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Response {
                private int season;
                private String firstName;
                private String lastName;
                private String team;
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

                public Response(PlayerStat playerStat) {
                        this.season = playerStat.getSeason();
                        this.firstName = playerStat.getPlayer().getFirstName();
                        this.lastName = playerStat.getPlayer().getLastName();
                        this.team = playerStat.getTeam().getName();
                        this.position = playerStat.getPosition();
                        this.age = playerStat.getAge();
                        this.experience = playerStat.getExperience();
                        this.gp = playerStat.getGp();
                        this.gs = playerStat.getGs();
                        this.mp = playerStat.getMp();
                        this.fg = playerStat.getFg();
                        this.fga = playerStat.getFga();
                        this.fgPercent = playerStat.getFgPercent();
                        this.x3p = playerStat.getX3p();
                        this.x3pa = playerStat.getX3pa();
                        this.x3pPercent = playerStat.getX3pPercent();
                        this.x2p = playerStat.getX2p();
                        this.x2pa = playerStat.getX2pa();
                        this.x2pPercent = playerStat.getX2pPercent();
                        this.eFgPercent = playerStat.getEFgPercent();
                        this.ft = playerStat.getFt();
                        this.fta = playerStat.getFta();
                        this.ftPercent = playerStat.getFtPercent();
                        this.orb = playerStat.getOrb();
                        this.drb = playerStat.getDrb();
                        this.trb = playerStat.getTrb();
                        this.ast = playerStat.getAst();
                        this.stl = playerStat.getStl();
                        this.blk = playerStat.getBlk();
                        this.tov = playerStat.getTov();
                        this.pf = playerStat.getPf();
                        this.pts = playerStat.getPts();
                }
        }
}
