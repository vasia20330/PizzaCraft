package com.example.pizzacraftmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth->auth

                        .requestMatchers("/listUsers").hasRole("ADMIN")
                        .requestMatchers("/listProduct").hasAnyRole("COOK","ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(form->form
                        .loginPage("/formAdmin")
                        .successHandler(customAuthenticationSuccessHandler())
                        .failureUrl("/formAdmin?error=true")
                        .permitAll()
                );



        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        return  new CustomAuthenticationSuccessHandler();
    }
}
