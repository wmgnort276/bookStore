package com.example.demo.securityTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.concurrent.TimeUnit;

import static com.example.demo.securityTest.ApplicationPermission.*;
import static com.example.demo.securityTest.ApplicationRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Needed for preAuthorize in controller
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf (cross side request forgery):
        http
                .csrf().disable() // when it is able, it will require cookie from user's request
                .authorizeRequests()
                 .antMatchers("/", "/api/v1").permitAll()
//                .antMatchers("/api/v1/*").hasRole(ADMIN.name())
//                .antMatchers(HttpMethod.POST, "/api/v1/*").hasAuthority(BOOK_MODIFY.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/api/v1/**").hasAuthority(BOOK_MODIFY.getPermission())
//                .antMatchers(HttpMethod.GET, "/api/v1/*").hasAnyRole(USER.name(), ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
//                .formLogin()
//                .and()
//                .rememberMe();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("namvn")
                .password(passwordEncoder().encode("123"))
//                .roles(USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
