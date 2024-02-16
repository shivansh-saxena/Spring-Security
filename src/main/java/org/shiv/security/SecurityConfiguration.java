package org.shiv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManagerService(){
        //in real world prod application we do not use withDefaultPasswordEncoder
        //noinspection deprecation
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("abcd")
                .password("abcd")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
