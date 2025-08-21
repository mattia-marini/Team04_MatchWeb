package mmarini.unitn.team04_matchweb.client;


import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@FeignClient(name = "matchCalendarClient", url = "${api.base.url}")
public interface MatchCalendarClient {
    @GetMapping("/api/matches/calendar")
    Map<Integer, Map<LocalDate, List<Match>>> getMatchCalendar();
}
