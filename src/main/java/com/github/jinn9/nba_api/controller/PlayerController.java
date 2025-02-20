package com.github.jinn9.nba_api.controller;

import com.github.jinn9.nba_api.dto.PlayerDto;
import com.github.jinn9.nba_api.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/players")
@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping
    public Response<List<PlayerDto>> getPlayers() {
        List<PlayerDto> players = playerRepository.findAll()
                .stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
        return new Response<>(players);
    }
}
