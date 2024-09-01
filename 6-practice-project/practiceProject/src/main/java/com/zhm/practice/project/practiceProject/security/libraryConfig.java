package com.zhm.practice.project.practiceProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class libraryConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager theUserDetails = new JdbcUserDetailsManager(dataSource);

        theUserDetails.setUsersByUsernameQuery("select username, password, enabled from users where username = ?");

        theUserDetails.setAuthoritiesByUsernameQuery("select username, role from roles where username = ?");

        return theUserDetails;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET, "/library/members").hasAnyRole("ADMIN", "LIBRARIAN")
                    .requestMatchers(HttpMethod.GET, "/library/librarians").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/library/admins").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/library/members/**").hasAnyRole("ADMIN", "LIBRARIAN")
                    .requestMatchers(HttpMethod.GET, "/library/librarians/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/library/admins/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/library/members").hasAnyRole("ADMIN", "LIBRARIAN")
                    .requestMatchers(HttpMethod.POST, "/library/librarians").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/library/admins").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/library/members/**").hasAnyRole("ADMIN", "LIBRARIAN")
                    .requestMatchers(HttpMethod.PUT, "/library/librarians/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/library/admins/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/library/members/**").hasAnyRole("ADMIN", "LIBRARIAN")
                    .requestMatchers(HttpMethod.DELETE, "/library/librarians/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/library/admins/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf ->
                csrf.disable()
        );

        return http.build();
    }
}
