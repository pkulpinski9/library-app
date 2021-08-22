package com.kulpinski.libraryapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable();
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/books/all").authenticated()
                .antMatchers(HttpMethod.POST,"/api/books/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/books/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/books/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/rent/").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/api/return/").hasRole("USER")
                .antMatchers("/api/users/all").hasRole("ADMIN")
                //.antMatchers("/console").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }

}
