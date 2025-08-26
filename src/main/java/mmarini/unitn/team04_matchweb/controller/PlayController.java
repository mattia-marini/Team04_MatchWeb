package mmarini.unitn.team04_matchweb.controller;


import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import mmarini.unitn.team04_matchweb.service.BetService;
import mmarini.unitn.team04_matchweb.service.PartiteWebService;
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

    private final PartiteWebService partiteWebService;
    private final BetService betService;

    public PlayController(PartiteWebService partiteWebService, BetService betService) {
        this.partiteWebService = partiteWebService;
        this.betService = betService;
    }

    @GetMapping("/play")
    public String playBetPageDefault(Principal principal, Model model) {
        return playBetPage(principal, LocalDate.now(), model);
    }

    @GetMapping("/play/{date}")
    public String playBetPage(Principal principal, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        try {
            Optional<Long> pointsToday = betService.getUserPointsByDate(principal.getName(), date);
            Map<Integer, List<Match>> calendar = partiteWebService.getMatchCalendarByDate(date);

            model.addAttribute("calendar", calendar);
            model.addAttribute("date", date);
            model.addAttribute("pointsToday", pointsToday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/play";
    }
}
