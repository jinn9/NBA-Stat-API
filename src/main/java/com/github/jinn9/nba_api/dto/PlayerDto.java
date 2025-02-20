package com.github.jinn9.nba_api.dto;

import com.github.jinn9.nba_api.entity.Player;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerDto {
    private String firstName;
    private String lastName;
    private String position;
    private int height;
    private int weight;
    private String college;
    private LocalDate birthDate;

    public PlayerDto(Player player) {
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.position = player.getPosition();
        this.height = player.getHeight();
        this.weight = player.getWeight();
        this.college = player.getCollege();
        this.birthDate = player.getBirthDate();
    }
}
