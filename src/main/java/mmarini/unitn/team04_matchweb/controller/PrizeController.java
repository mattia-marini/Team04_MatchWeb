package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.service.PrizeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PrizeController {

    private final PrizeService prizeService;

    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @PostMapping("/assign-awards")
    public String assignPrizes(@RequestParam List<String> usernames, @RequestParam List<String> awards) {
        prizeService.assignAwards(usernames, awards);
        return "redirect:/award-assigned";
    }
}
