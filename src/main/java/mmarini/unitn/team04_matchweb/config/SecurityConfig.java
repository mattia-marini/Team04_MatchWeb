package mmarini.unitn.team04_matchweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/user", "/user/**").authenticated() // first, protects /user
                .requestMatchers("/**", "/login").permitAll() // then public pages
        ).formLogin(form -> form
                        //.loginPage("/login")   // your custom login page
                        .defaultSuccessUrl("/user", true)
                //.permitAll()
        ).logout(logout -> logout.permitAll());

        // Needed for H2 console frames
        http.headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin())
        );

        // Disable CSRF for H2 console
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
        );

        return http.build();
    }

    @Bean
    public UserDetailsService users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
    }
}