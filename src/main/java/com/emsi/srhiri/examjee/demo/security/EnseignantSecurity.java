package com.emsi.srhiri.examjee.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EnseignantSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = pwdEncoder();
        auth.inMemoryAuthentication().withUser("user").password(pe.encode("123")).
                roles("USER","USER");
        auth.inMemoryAuthentication().withUser("enseignant").password(pe.encode("123")).
                roles("USER", "ENSEIGNANT");
        auth.inMemoryAuthentication().withUser("scolarite").password(pe.encode("123")).
                roles("USER", "SCOLARITE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().antMatchers("consulter/**").
                hasRole("USER");
        http.authorizeRequests().antMatchers("/save**/**\", \"/form**/**").
                hasRole("ENSEIGNANT");
        http.authorizeRequests().antMatchers("/save**/**\", \"/delete**/**\", \"/form**/**").
                hasRole("SCOLARITE");
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf();
        http.exceptionHandling().accessDeniedPage("/unauthorizedAccess");
    }

    @Autowired
    public PasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }
}
