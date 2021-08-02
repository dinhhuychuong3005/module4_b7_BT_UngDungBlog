package com.codegym.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}30051995").roles("USER")
                .and()
                .withUser("admin").password("{noop}123456").roles("ADMIN");
    }
@Override
    protected void configure(HttpSecurity http) throws Exception{
http.authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().antMatchers("/blogs**").hasRole("USER")
        .and()
        .authorizeRequests().antMatchers("/category**").hasRole("ADMIN")
        .and()
        .formLogin()
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
}
}
