package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.service.PrizeService;
import mmarini.unitn.team04_matchweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class PrizeController {

    private final PrizeService prizeService;
    private final UserService userService;

    public PrizeController(PrizeService prizeService, UserService userService) {
        this.prizeService = prizeService;
        this.userService = userService;
    }

    @GetMapping("/assign-awards")
    public String assignAwardsPage(Model model) {
        List<UserDetailsExtra> users = userService.getAllUsernameAsc();
        Map<String, Long> ranks = userService.getTotalScorePerUser();
        users.sort(Comparator.comparing(u -> ranks.getOrDefault(u.getUsername(), 0L), Comparator.reverseOrder()));

        if (users.size() > 3) {
            users = users.subList(0, 3);
        }

        model.addAttribute("users", users);
        model.addAttribute("ranks", ranks);
        return "assign-awards";
    }

    @GetMapping("/award-assigned")
    public String awardAssignedPage() {
        return "award-assigned";
    }

    // Api
    @PostMapping("/api/assign-awards")
    public String assignPrizes(@RequestParam List<String> usernames, @RequestParam List<String> awards) {
        prizeService.assignAwards(usernames, awards);
        return "redirect:/award-assigned";
    }
}
