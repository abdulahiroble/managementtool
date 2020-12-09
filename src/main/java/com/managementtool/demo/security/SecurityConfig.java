package com.managementtool.demo.security;
import com.managementtool.demo.services.CustomManagerDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    CustomManagerDetailsService customManagerService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/projects.html").hasAuthority("MANAGER")
                .antMatchers("/home.html").permitAll()
                .antMatchers("/createaccount.html").permitAll()
                .and().formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=true");

    }
}
