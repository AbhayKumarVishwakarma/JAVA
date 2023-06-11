package com.example.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    public SecurityFilterChain masaiSecurityFilter(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests( auth -> {
//                auth.anyRequest().permitAll();  // it will give permission to all http request
                auth.requestMatchers("/admin","/welcome").permitAll()
                        .anyRequest().authenticated();
            }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

            return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetails(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
        UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
        manager.createUser(admin);;
        manager.createUser(user);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
