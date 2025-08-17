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
    private final JdbcTemplate jdbcTemplate;

    public RegistrationService(JdbcUserDetailsManager userDetailsManager,
                               PasswordEncoder passwordEncoder,
                               UserDetailsExtraRepository extraRepository,
                               JdbcTemplate jdbcTemplate) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.extraRepository = extraRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void register(RegistrationForm registrationForm, String role) {

        if (userDetailsManager.userExists(registrationForm.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        // 1) Create core user
        UserDetails user = User.builder()
                .username(registrationForm.getUsername())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .roles(role) // Spring will prefix with ROLE_
                .build();

        System.out.println("User created");

        userDetailsManager.createUser(user);

        // 2) Fetch the generated user_id from USERS
        /*
        Long userId = jdbcTemplate.queryForObject(
                "SELECT id FROM USERS WHERE username = ?",
                Long.class,
                registrationForm.getUsername()
        );
        */

        //System.out.println("Fetched new id " + userId);

        // 3) Insert into USER_DETAILS_EXTRA
        UserDetailsExtra extra = new UserDetailsExtra();
        extra.setUsername(registrationForm.getUsername());
        extra.setFirstName(registrationForm.getFirstName());
        extra.setLastName(registrationForm.getLastName());
        extra.setMail(registrationForm.getMail());
        extra.setBirthDate(registrationForm.getBirthDate());

        extraRepository.save(extra);
    }
}
