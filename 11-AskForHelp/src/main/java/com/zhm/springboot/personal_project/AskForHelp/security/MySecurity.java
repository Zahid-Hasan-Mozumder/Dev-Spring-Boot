package com.zhm.springboot.personal_project.AskForHelp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class MySecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager theUserDetails = new JdbcUserDetailsManager(dataSource);
        theUserDetails.setUsersByUsernameQuery("select username, password, enabled from members where username=?");
        theUserDetails.setAuthoritiesByUsernameQuery("select username, role from roles where username=?");
        return theUserDetails;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/").hasAnyRole("USER", "SP")
                                .requestMatchers("/add").hasRole("USER")
                                .requestMatchers("/added").hasRole("USER")
                                .requestMatchers("/edit").hasRole("USER")
                                .requestMatchers("/completed").hasRole("USER")
                                .requestMatchers("/request").hasRole("SP")
                                .requestMatchers(HttpMethod.GET, "/api/queries/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/queries").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/queries/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/queries/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/accessDenied")
                )
                .formLogin(login ->
                    login
                            .loginPage("/login")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );

        return http.build();
    }
}
