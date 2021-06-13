package com.eugene.spring.boot.web.customer_service_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .authorities("SEARCH_PRIVILEGES", "UPDATE_PRIVILEGES", "ROLE_ADMIN")
//                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("user")
//                .roles("USER")
                .authorities("UPDATE_PRIVILEGES", "ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/customers/", "/customers/updateAddressToCustomer/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/customers/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/customers/updateAddressToCustomer/**").hasAuthority("UPDATE_PRIVILEGES")
                .antMatchers("/customers/search").hasAuthority("SEARCH_PRIVILEGES")
                .antMatchers("/customers/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
