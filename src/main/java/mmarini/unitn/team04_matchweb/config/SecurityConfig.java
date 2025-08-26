package mmarini.unitn.team04_matchweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

                        // Apis
                        .requestMatchers("/api/save-bet", "/api/change-password", "/api/write-review").authenticated()
                        .requestMatchers("/api/assign-awards", "/api/upgrade").hasRole("ADMIN")

                        // Pages
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/profile", "/calendar", "/change-password", "/play", "/play/**", "/write-review").hasAnyRole("ADMIN", "USER", "MODERATOR") // user pages
                        .requestMatchers("/user-list", "/user-ranking", "/assign-awards", "/upgrade").hasRole("ADMIN") // admin pages
                        .requestMatchers("/**").permitAll() // then public pages
                )
                .formLogin(form -> form
                        .loginPage("/login")       // your custom login page
                        .loginProcessingUrl("/login") // where the form POSTs
                        .defaultSuccessUrl("/dashboard", true) // where to go after login
                        .failureUrl("/login?error=true") // error redirect
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout")
                        .permitAll()
                );

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
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}