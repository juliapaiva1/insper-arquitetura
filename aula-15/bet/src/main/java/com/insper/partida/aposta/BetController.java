package com.insper.partida.aposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping
    public Bet createBet(@RequestBody Bet bet) {
        return betService.saveBet(bet);
    }

    @GetMapping
    public List<Bet> getBets() {
        return betService.listBets();
    }

    @PutMapping("/{betId}/verify")
    public Bet verifyBet(@PathVariable Integer betId) {
        return betService.verifyBet(betId);
    }

    @GetMapping("/{partidaId}")
    public Map<String, Object> getBetsByPartida(@PathVariable Integer partidaId) {
        Partida partida = partidaService.getPartidaById(partidaId);

        if (partida == null) {
            throw new PartidaNotFoundException(partidaId);
        }

        List<Bet> bets = betService.listBetsByPartida(partidaId);

        Map<String, Object> response = new HashMap<>();
        response.put("id", partida.getId());
        response.put("home", partida.getHomeTeam());
        response.put("away", partida.getAwayTeam());
        response.put("bets", bets);

        return response;
}


}
