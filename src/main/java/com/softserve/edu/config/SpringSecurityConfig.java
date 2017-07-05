//package com.softserve.edu.config;
//
//import com.softserve.edu.service.impl.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created by Kostya on 05.07.2017.
// */
//@Configuration
//@ComponentScan("com.softserve.edu.*")
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public UserDetailsServiceImpl getUserDetailsServiceImpl() {
//        return new UserDetailsServiceImpl();
//    }
//}
