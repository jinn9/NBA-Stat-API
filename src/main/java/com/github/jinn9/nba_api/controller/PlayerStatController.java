package com.github.jinn9.nba_api.controller;

import com.github.jinn9.nba_api.dto.PlayerStatWithPlayerAndTeamDto;
import com.github.jinn9.nba_api.repository.PlayerStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/playerstats")
@RestController
public class PlayerStatController {

    private final PlayerStatRepository playerStatRepository;

    @GetMapping
    public Response<List<PlayerStatWithPlayerAndTeamDto.Response>> getPlayerStats() {
        List<PlayerStatWithPlayerAndTeamDto.Response> playerStats = playerStatRepository.findAllWithPlayerAndTeam()
                .stream()
                .map(PlayerStatWithPlayerAndTeamDto.Response::new)
                .collect(Collectors.toList());

        return new Response<>(playerStats);
    }
}
