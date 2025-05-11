package com.ganzouri.employees.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT e.email, e.password, e.active FROM employee e WHERE e.email='?'");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT e.email, r.role_name FROM employee e INNER JOIN role r ON e.role_id = r.id WHERE e.email='?'");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/docs/**","swagger-ui/**","v3/api-docs/**","swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.GET,"/employee/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/employee").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/employee/**").hasRole("ADMIN"));
        http.httpBasic(httpBasicCustomizer -> httpBasicCustomizer.disable());

        http.csrf(csrf -> csrf.disable());
        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint()));
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> response.sendError(401);
    }
}
