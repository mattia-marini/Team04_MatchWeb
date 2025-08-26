package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.client.TeamClient;
import mmarini.unitn.team04_matchweb.service.PartiteWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportController {

    private final PartiteWebService partiteWebService;

    public SportController(PartiteWebService partiteWebService) {
        this.partiteWebService = partiteWebService;
    }

    @GetMapping("/sport/soccer")
    public String soccerPage(Model model) {
        model.addAttribute("teams", partiteWebService.getAllTeams());
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
