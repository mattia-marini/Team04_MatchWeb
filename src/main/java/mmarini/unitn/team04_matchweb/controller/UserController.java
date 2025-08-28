package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
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
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Pages
    @GetMapping("/user-list")
    public String userListPage(Model model) {
        model.addAttribute("users", userService.getAllUsernameAsc());
        model.addAttribute("authorities", userService.getAuthorityMap());
        return "admin/user-list";
    }

    @GetMapping("/user-ranking")
    public String userRankingPage(Model model) {
        List<UserDetailsExtra> users = userService.getAllUsernameAsc();
        Map<String, Long> ranks = userService.getTotalScorePerUser();
        users.sort(Comparator.comparing(u -> ranks.getOrDefault(u.getUsername(), 0L), Comparator.reverseOrder()));

        model.addAttribute("users", users);
        model.addAttribute("ranks", ranks);
        return "admin/user-ranking";
    }


    @GetMapping("/upgrade")
    public String upgradePage(Model model) {
        model.addAttribute("users", userService.getAllUsernameAsc());
        model.addAttribute("authorities", userService.getAuthorityMap());
        return "admin/upgrade";
    }

    // Apis
    @PostMapping("/api/upgrade")
    public String updateRoles(@RequestParam List<String> usernames, @RequestParam String role, Model model) {
        boolean updated = userService.updateUsersRole(role, usernames);
        return "redirect:/upgrade";
    }


}
