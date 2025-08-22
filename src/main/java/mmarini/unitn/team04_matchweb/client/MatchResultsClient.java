package mmarini.unitn.team04_matchweb.client;

import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@FeignClient(name = "matchResultsClient", url = "${api.base.url}")
public interface MatchResultsClient {

    @GetMapping("/api/matches/calendar/results/{date}")
    Map<Integer, List<Match>> getMatchResultsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
