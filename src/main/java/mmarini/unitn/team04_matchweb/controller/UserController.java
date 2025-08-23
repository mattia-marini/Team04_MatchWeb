package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.Authority;
import mmarini.unitn.team04_matchweb.repository.AuthorityRepository;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    UserDetailsExtraRepository userDetailsExtraRepository;
    AuthorityRepository authorityRepository;

    @Autowired
    public UserController(UserDetailsExtraRepository userDetailsExtraRepository, AuthorityRepository authorityRepository) {
        this.userDetailsExtraRepository = userDetailsExtraRepository;
        this.authorityRepository = authorityRepository;
    }

    @GetMapping("/user-list")
    public String userListPage(Model model) {
        List<Authority> authorities = authorityRepository.findAll();
        Map<String, String> authoritiesMap = new LinkedHashMap<>();
        authorities.forEach(authority -> {
            authoritiesMap.put(authority.getUsername(), authority.getAuthority());
        });

        model.addAttribute("users", userDetailsExtraRepository.findAll());
        model.addAttribute("authorities", authoritiesMap);
        return "user-list";
    }

    @GetMapping("/user-ranking")
    public String userRankingPage() {
        return "user-ranking";
    }

}
