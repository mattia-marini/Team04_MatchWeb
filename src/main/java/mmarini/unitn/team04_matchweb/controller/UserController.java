package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.repository.AuthorityRepository;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import mmarini.unitn.team04_matchweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    UserDetailsExtraRepository userDetailsExtraRepository;
    UserService userService;

    @Autowired
    public UserController(UserDetailsExtraRepository userDetailsExtraRepository, AuthorityRepository authorityRepository, UserService userService) {
        this.userDetailsExtraRepository = userDetailsExtraRepository;
        this.userService = userService;
    }

    @GetMapping("/user-list")
    public String userListPage(Model model) {
        model.addAttribute("users", userService.getAllUsernameAsc());
        model.addAttribute("authorities", userService.getAuthorityMap());
        return "user-list";
    }

    @GetMapping("/user-ranking")
    public String userRankingPage(Model model) {
        List<UserDetailsExtra> users = userService.getAllUsernameAsc();
        Map<String, Long> ranks = userService.getTotalScorePerUser();
        users.sort(Comparator.comparing(u -> ranks.getOrDefault(u.getUsername(), 0L), Comparator.reverseOrder()));

        model.addAttribute("users", users);
        model.addAttribute("ranks", ranks);
        return "user-ranking";
    }

}
