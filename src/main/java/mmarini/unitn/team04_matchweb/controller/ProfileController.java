package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.dto.ProfileStats;
import mmarini.unitn.team04_matchweb.model.entity.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.service.ProfileInfosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private final ProfileInfosService profileInfosService;

    public ProfileController(ProfileInfosService profileInfosService) {
        this.profileInfosService = profileInfosService;
    }


    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal) {
        String username = principal.getName();

        ProfileStats profileStats = profileInfosService.getProfileStats(username);
        UserDetailsExtra userDetailsExtra = profileInfosService.getUserDetailsExtra(username);

        model.addAttribute("profileStats", profileStats);
        model.addAttribute("userDetailsExtra", userDetailsExtra);
        return "user/profile";
    }

}
