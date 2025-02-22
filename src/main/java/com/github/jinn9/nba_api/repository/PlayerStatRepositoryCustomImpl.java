package com.github.jinn9.nba_api.repository;

import com.github.jinn9.nba_api.dto.PlayerStatDto;
import com.github.jinn9.nba_api.entity.PlayerStat;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.github.jinn9.nba_api.entity.QPlayerStat.*;

public class PlayerStatRepositoryCustomImpl implements PlayerStatRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PlayerStatRepositoryCustomImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PlayerStat> findAllWithPlayerAndTeam(PlayerStatDto.Request params) {
        return queryFactory
                .selectFrom(playerStat)
                .join(playerStat.player).fetchJoin()
                .join(playerStat.team).fetchJoin()
                .where(
                        firstNameEq(params.getFirstName()),
                        lastNameEq(params.getLastName()),
                        teamEq(params.getTeam()),
                        seasonEq(params.getSeason()),
                        positionEq(params.getPosition())
                )
                .fetch();
    }

    @Override
    public Page<PlayerStat> findAllWithPlayerAndTeam(PlayerStatDto.Request params, Pageable pageable) {
        List<PlayerStat> content = queryFactory
                .selectFrom(playerStat)
                .join(playerStat.player).fetchJoin()
                .join(playerStat.team).fetchJoin()
                .where(
                        firstNameEq(params.getFirstName()),
                        lastNameEq(params.getLastName()),
                        teamEq(params.getTeam()),
                        seasonEq(params.getSeason()),
                        positionEq(params.getPosition())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(playerStat.count())
                .from(playerStat)
                .where(
                        firstNameEq(params.getFirstName()),
                        lastNameEq(params.getLastName()),
                        teamEq(params.getTeam()),
                        seasonEq(params.getSeason()),
                        positionEq(params.getPosition())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    public static BooleanExpression firstNameEq(String firstName) {
        return StringUtils.hasText(firstName) ? playerStat.player.firstName.equalsIgnoreCase(firstName) : null;
    }

    public static BooleanExpression lastNameEq(String lastName) {
        return StringUtils.hasText(lastName) ? playerStat.player.lastName.equalsIgnoreCase(lastName) : null;
    }

    public static BooleanExpression teamEq(String team) {
        return StringUtils.hasText(team) ? playerStat.team.name.equalsIgnoreCase(team) : null;
    }

    public static BooleanExpression seasonEq(String season) {
        return StringUtils.hasText(season) ? playerStat.season.eq(season) : null;
    }

    public static BooleanExpression positionEq(String position) {
        return StringUtils.hasText(position) ? playerStat.position.equalsIgnoreCase(position) : null;
    }
}
