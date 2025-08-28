package mmarini.unitn.team04_matchweb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Map;

@FeignClient(name = "matchResultsClient", url = "${api.base.url}")
public interface MatchResultsClient {

    @GetMapping("/api/matches/calendar/results/{date}")
    Map<Integer, Map<Integer, Integer>> getMatchResultsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);


    @GetMapping("/api/matches/calendar/results/{date}/{championshipId}")
    Map<Integer, Integer> getMatchResultsByDateAndChampionshipId(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable("championshipId") Integer championshipId);
}
