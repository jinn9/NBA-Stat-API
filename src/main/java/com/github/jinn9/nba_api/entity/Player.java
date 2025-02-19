package com.github.jinn9.nba_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Player {

    @Id @GeneratedValue
    @Column(name = "player_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private int height;
    private int weight;
    private String college;
    private LocalDateTime birthDate;
}
