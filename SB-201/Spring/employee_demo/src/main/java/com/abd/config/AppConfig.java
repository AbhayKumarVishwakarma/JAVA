package com.abd.config;

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
                        .requestMatchers(HttpMethod.GET,"/welcome").permitAll()
                        .requestMatchers(HttpMethod.POST,"/employee/register").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/employee/{id}").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET, "/employee/{id}","/employees").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employee/{id}").hasAnyRole("USER","ADMIN")
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
