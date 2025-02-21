package com.github.jinn9.nba_api.controller;

import com.github.jinn9.nba_api.dto.PlayerStatDto;
import com.github.jinn9.nba_api.repository.PlayerStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public Response<List<PlayerStatDto.Response>> getPlayerStats(@ModelAttribute PlayerStatDto.Request params) {
        List<PlayerStatDto.Response> playerStats = playerStatRepository.findAllWithPlayerAndTeam(params)
                .stream()
                .map(PlayerStatDto.Response::new)
                .collect(Collectors.toList());

        return new Response<>(playerStats);
    }
}
