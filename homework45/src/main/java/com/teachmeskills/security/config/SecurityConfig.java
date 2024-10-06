package com.teachmeskills.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(cust ->
                cust.
                        requestMatchers("/home").permitAll().
                        requestMatchers("/task").authenticated().
                        requestMatchers("/order").hasRole("SELLER")
        ).httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user1 =
                User.withUsername("user").password(encoder.encode("root")).build();
        UserDetails user2 =
                User.withUsername("seller").password(encoder.encode("root")).roles("SELLER").build();


        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
