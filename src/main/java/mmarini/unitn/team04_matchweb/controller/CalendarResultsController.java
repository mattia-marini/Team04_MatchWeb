package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.client.MatchResultsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
public class CalendarResultsController {

    private final MatchResultsClient matchResultsClient;

    @Autowired
    public CalendarResultsController(MatchResultsClient matchResultsClient) {
        this.matchResultsClient = matchResultsClient;
    }

    // Apis
    @GetMapping("/api/calendar/results/{date}")
    public Map<Integer, Map<Integer, Integer>> calendarResultsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return matchResultsClient.getMatchResultsByDate(date);
    }

    // Unused
    @GetMapping("/api/calendar/results/{date}/{championshipId}")
    public Map<Integer, Integer> calendarResultsByDateAndChampionshipId(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable("championshipId") Integer championshipId) {
        return matchResultsClient.getMatchResultsByDateAndChampionshipId(date, championshipId);
    }
}
