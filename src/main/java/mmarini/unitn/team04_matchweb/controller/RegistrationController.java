package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.dto.RegistrationForm;
import mmarini.unitn.team04_matchweb.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/signup")
    public String registerPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "public/signup";
    }

    // Api
    @PostMapping("/api/signup")
    public String registerUser(@ModelAttribute("registrationForm") RegistrationForm form, Model model, RedirectAttributes redirectAttributes) {
        try {
            registrationService.register(form, "USER");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/signup";
        }

        return "redirect:/registration-successful";
    }
}
