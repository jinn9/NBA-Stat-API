package com.github.jinn9.nba_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate birthDate;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player(String firstName, String lastName, String position, int height, int weight,
                  String college, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.birthDate = birthDate;
    }
}
