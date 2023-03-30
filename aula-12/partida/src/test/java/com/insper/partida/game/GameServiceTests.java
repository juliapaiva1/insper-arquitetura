package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class GameServiceTests {

    @InjectMocks
    GameService gameService;

    @Mock
    TeamService teamService;

    @Mock
    GameRepository gameRepository;

    @Test
    void test_listGamesWhenHomeAndAwayNotNull() {

        Team team = new Team();
        team.setId(1);
        team.setIdentifier("time-1");

        Team team2 = new Team();
        team2.setId(2);
        team2.setIdentifier("time-2");

        Mockito.when(teamService.getTeam("time-1")).thenReturn(team);
        Mockito.when(teamService.getTeam("time-2")).thenReturn(team2);
        Mockito.when(gameRepository.findByHomeAndAway(team, team2, null))
                .thenReturn(null);

        Page<Game> resp = gameService.listGames("time-1", "time-2", null, null);
        Assertions.assertNull(resp);

    }

}
