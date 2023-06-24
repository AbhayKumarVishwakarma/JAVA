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
                        .requestMatchers(HttpMethod.POST,"/masaiOrder/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/masaiOrder/welcome").permitAll()
                        .requestMatchers(HttpMethod.POST,"/masaiOrder/orders").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET, "/masaiOrder/orders","/masaiOrder/orders/{oId}").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET, "/masaiOrder/orders/name","/masaiOrder/orders/date","/masaiOrder/orders/revenue").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.PUT, "/masaiOrder/orders/{oId}").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.DELETE, "/masaiOrder/orders/{oId}").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET, "/masaiOrder/**").hasAnyRole("ADMIN","USER")
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
