package mmarini.unitn.team04_matchweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String homePage() {
        // This returns the name of the HTML file in templates (without .html extension)
        return "index";
    }

    @GetMapping("/registration-successful")
    public String registrationSuccessful() {
        // This returns the name of the HTML file in templates (without .html extension)
        return "registration-successful";
    }

    @GetMapping("/login")
    public String loginPage() {
        // This returns the name of the HTML file in templates (without .html extension)
        return "login";
    }

    @GetMapping("/user")
    public String userPage() {
        // This returns the name of the HTML file in templates (without .html extension)
        return "user";
    }
}
