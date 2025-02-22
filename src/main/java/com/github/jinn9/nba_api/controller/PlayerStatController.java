package com.github.jinn9.nba_api.controller;

import com.github.jinn9.nba_api.dto.PlayerStatDto;
import com.github.jinn9.nba_api.repository.PlayerStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<PlayerStatDto.Response> getPlayerStats(@ModelAttribute PlayerStatDto.Request params, Pageable pageable) {
        return playerStatRepository.findAllWithPlayerAndTeam(params, pageable)
                .map(PlayerStatDto.Response::new);
    }
}
