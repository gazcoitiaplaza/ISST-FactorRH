package es.upm.dit.isst.factorrh04.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "SELECT email, password FROM empleado WHERE email = ?";
        String authsByUsernameQuery = "SELECT email, authority FROM authorities WHERE email = ?";
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(usersByUsernameQuery);
        users.setAuthoritiesByUsernameQuery(authsByUsernameQuery);
        return users;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/login", "/static/**", "h2-console/**").permitAll();
                    auth.requestMatchers("/").hasAnyRole("EMP");
                    auth.requestMatchers("/").hasAnyRole("RH");
                    auth.requestMatchers("/h2/**").permitAll();
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().permitAll();
                })
                .formLogin(form -> form.loginPage("/login").permitAll());
                http.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));

        return http.build();
    }
}