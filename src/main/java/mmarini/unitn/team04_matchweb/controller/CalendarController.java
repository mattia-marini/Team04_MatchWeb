package mmarini.unitn.team04_matchweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import mmarini.unitn.team04_matchweb.client.MatchCalendarClient;
import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    private final MatchCalendarClient matchCalendarClient;

    public CalendarController(MatchCalendarClient matchCalendarClient) {
        this.matchCalendarClient = matchCalendarClient;
    }

    @GetMapping("/calendar")
    public String showCalendar(Model model) {
        try {
            Map<Integer, Map<LocalDate, List<Match>>> calendar = matchCalendarClient.getMatchCalendar();
            model.addAttribute("calendar", calendar);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "calendar";
    }

    @GetMapping("/play")
    public String playBetPageDefault(Model model) {
        return playBetPage(LocalDate.now(), model);
    }

    @GetMapping("/play/{date}")
    public String playBetPage(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        try {

            Map<Integer, List<Match>> calendar = matchCalendarClient.getMatchCalendarByDate(date);
            model.addAttribute("calendar", calendar);
            model.addAttribute("date", date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "play";
    }

}
