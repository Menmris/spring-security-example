package com.example.springsecurityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("jola")
                .password("{noop}aaa")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("bajtek")
                .password("{noop}bbb")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
