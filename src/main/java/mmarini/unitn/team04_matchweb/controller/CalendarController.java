package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.dto.rest.Match;
import mmarini.unitn.team04_matchweb.service.PartiteWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    private final PartiteWebService partiteWebService;

    public CalendarController(PartiteWebService partiteWebService) {
        this.partiteWebService = partiteWebService;
    }

    // Pages
    @GetMapping("/calendar")
    public String showCalendar(Model model) {

        Map<Integer, Map<LocalDate, List<Match>>> calendar = partiteWebService.getMatchCalendar();
        model.addAttribute("calendar", calendar);

        return "user/calendar";
    }


}
