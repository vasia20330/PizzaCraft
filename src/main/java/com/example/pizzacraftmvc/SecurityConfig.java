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

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth->auth

                        .requestMatchers("/listUsers").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(form->form
                        .loginPage("/formAdmin")
                        .defaultSuccessUrl("/formBootstrap")
                        .permitAll()
                );



        return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails admin= User.withUsername("admin")
                .username("admin")
                .password(passwordEncoder().encode("root"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
