package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.RegistrationForm;
import mmarini.unitn.team04_matchweb.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/signup")
    public String registerPage(Model model) {
        // This returns the name of the HTML file in templates (without .html extension)
        model.addAttribute("registrationForm", new RegistrationForm());
        return "signup";
    }

    // Api
    @PostMapping("/api/signup")
    public String registerUser(@ModelAttribute("registrationForm") RegistrationForm form, Model model) {
        registrationService.register(form, "USER");

        return "redirect:/registration-successful";
    }
}
