package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.Bet;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/save-bet")
public class BetController {

    @Autowired
    private BetRepository betRepository;

    @PostMapping
    public ResponseEntity<Bet> createBet(@RequestBody Bet bet) {
        Bet savedBet = betRepository.save(bet);
        return ResponseEntity.ok(savedBet);
    }
}
