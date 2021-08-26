package com.exam.examen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    public String username = "Master";
    
    public String password = "SpringBoot";
    
    public String role = "admin";
    
    public String end_point = "/**";
    
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(username)
                .password("{noop}" + password)
                .roles(role);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, end_point).hasRole(role)
                .antMatchers(HttpMethod.POST, end_point).hasRole(role)
                .antMatchers(HttpMethod.DELETE, end_point).hasRole(role)
                .antMatchers(HttpMethod.PUT, end_point).hasRole(role)
                .and().csrf().disable().formLogin().disable();
    }
}