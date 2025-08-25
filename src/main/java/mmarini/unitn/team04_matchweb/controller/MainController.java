package mmarini.unitn.team04_matchweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePageNoIndex() {
        return "public/index";
    }

    @GetMapping("/index")
    public String homePage() {
        return "public/index";
    }

    @GetMapping("/sponsor")
    public String sponsorPage() {
        return "public/sponsor";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "info-pages/logout";
    }

    @GetMapping("/registration-successful")
    public String registrationSuccessful() {
        return "info-pages/registration-successful";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "public/login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }

    @GetMapping("/compute-scores")
    public String computeScores() {
        return "dashboard";
    }

}
