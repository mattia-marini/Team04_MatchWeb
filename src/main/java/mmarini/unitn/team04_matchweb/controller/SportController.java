package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.client.TeamClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportController {
    private final TeamClient teamClient;

    public SportController(TeamClient teamClient) {
        this.teamClient = teamClient;
    }


    @GetMapping("/sport/soccer")
    public String soccerPage(Model model) {
        model.addAttribute("teams", teamClient.getAllTeams());
        return "public/soccer";
    }

    @GetMapping("/sport/basket")
    public String basketPage() {
        return "info-pages/service-unavailable";
    }

    @GetMapping("/sport/tennis")
    public String tennisPage() {
        return "info-pages/service-unavailable";
    }
}
