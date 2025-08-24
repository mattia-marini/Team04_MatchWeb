package mmarini.unitn.team04_matchweb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChangePasswordController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public ChangePasswordController(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/change-password")
    public String showChangePasswordForm() {
        return "user/change-password";
    }


    // Api
    @PostMapping("/api/change-password")
    public String processChangePassword(
            @RequestParam("currentPassword") String currentPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
        if (!passwordEncoder.matches(currentPassword, userDetails.getPassword())) {
            redirectAttributes.addFlashAttribute("errorMessage", "La password attuale non è corretta");
            return "redirect:/change-password";
        }

        // Validate that new password and confirm password match
        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Le password non coincidono");
            return "redirect:/change-password";
        }

        try {
            userDetailsManager.changePassword(currentPassword, passwordEncoder.encode(newPassword));
            redirectAttributes.addFlashAttribute("successMessage", "Password cambiata con successo");
            return "redirect:/profile";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Si è verificato un errore: " + e.getMessage());
            return "redirect:/change-password";
        }
    }
}
