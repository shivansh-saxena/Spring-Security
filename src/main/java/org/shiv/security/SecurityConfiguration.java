package org.shiv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
        //noinspection deprecation
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("xyz")
                .password("abcd")
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(user);
        inMemoryUserDetailsManager.createUser(user2);
        return inMemoryUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
        {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/user").hasAnyRole("USER","ADMIN");
            auth.requestMatchers("/admin").hasAnyRole("ADMIN");
        }
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
