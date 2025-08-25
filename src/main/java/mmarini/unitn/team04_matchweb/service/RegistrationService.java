package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.RegistrationForm;
import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final JdbcUserDetailsManager userDetailsManager;
    private final UserDetailsExtraRepository extraRepository;

    private final PasswordEncoder passwordEncoder;

    public RegistrationService(JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder, UserDetailsExtraRepository extraRepository) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.extraRepository = extraRepository;
    }

    @Transactional
    public void register(RegistrationForm registrationForm, String role) {

        if (userDetailsManager.userExists(registrationForm.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        // 1) Create core user
        UserDetails user = User.builder().username(registrationForm.getUsername()).password(passwordEncoder.encode(registrationForm.getPassword())).roles(role) // Spring will prefix with ROLE_
                .build();

        userDetailsManager.createUser(user);

        // 2) Insert USER_DETAILS_EXTRA
        UserDetailsExtra extra = new UserDetailsExtra();
        extra.setUsername(registrationForm.getUsername());
        extra.setFirstName(registrationForm.getFirstName());
        extra.setLastName(registrationForm.getLastName());
        extra.setMail(registrationForm.getMail());
        extra.setBirthDate(registrationForm.getBirthDate());
        extra.setFavTeam(registrationForm.getFavTeam());
        extra.setSport(registrationForm.getSport());

        extraRepository.save(extra);
    }
}
