package com.masaiOrder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {
    @Bean
    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->{
                    auth
                        .requestMatchers(HttpMethod.POST,"/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/welcome").permitAll()
                        .requestMatchers(HttpMethod.POST,"/customer/{cusId}/vehicle").hasAnyRole("MANAGER","DRIVER","GUEST")
                        .requestMatchers(HttpMethod.GET, "/vehicles").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/vehicle/{vId}").hasAnyRole("MANAGER","DRIVER")
                        .requestMatchers(HttpMethod.PUT, "/vehicle/{vId}").hasAnyRole("MANAGER","DRIVER")
                        .requestMatchers(HttpMethod.DELETE, "/vehicle/{vId}").hasAnyRole("MANAGER","DRIVER")
                        .requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated();
                })
                .csrf(csrf -> csrf.disable())
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
