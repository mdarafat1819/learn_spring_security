package com.example.learn_spring_security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService UserDetailsServic() {
        UserDetails user = User.builder()
            .username("user")
            .password("{noop}ourpassword")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

}
