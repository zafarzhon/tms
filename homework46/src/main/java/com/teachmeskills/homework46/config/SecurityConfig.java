package com.teachmeskills.homework46.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(cust -> {
                    cust.loginPage("/auth");
                    cust.loginProcessingUrl("/auth");
                    cust.usernameParameter("login");
                    cust.passwordParameter("pass");
                })
                .logout(cust -> cust.logoutUrl("/logout"))
                .authorizeHttpRequests(cust ->
                        cust.requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/home", "/auth", "/register").permitAll()
                ).httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

