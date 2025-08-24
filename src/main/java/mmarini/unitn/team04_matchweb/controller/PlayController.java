package mmarini.unitn.team04_matchweb.controller;


import mmarini.unitn.team04_matchweb.client.MatchCalendarClient;
import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class PlayController {

    private final MatchCalendarClient matchCalendarClient;
    private final BetRepository betRepository;

    public PlayController(MatchCalendarClient matchCalendarClient, BetRepository betRepository) {
        this.matchCalendarClient = matchCalendarClient;
        this.betRepository = betRepository;
    }

    @GetMapping("/play")
    public String playBetPageDefault(Principal principal, Model model) {
        return playBetPage(principal, LocalDate.now(), model);
    }

    @GetMapping("/play/{date}")
    public String playBetPage(Principal principal, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        try {
            Optional<Integer> pointsToday = betRepository.getUserScoreByDay(principal.getName(), date);
            Map<Integer, List<Match>> calendar = matchCalendarClient.getMatchCalendarByDate(date);

            model.addAttribute("calendar", calendar);
            model.addAttribute("date", date);
            model.addAttribute("pointsToday", pointsToday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/play";
    }
}
