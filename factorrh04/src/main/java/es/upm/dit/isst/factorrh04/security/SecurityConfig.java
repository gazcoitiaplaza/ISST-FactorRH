package es.upm.dit.isst.factorrh04.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService jbdcUserDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "SELECT id_Empleado as username, password, true FROM Empleado WHERE id_Empleado = ?";
        String authsByUsernameQuery = "SELECT id_Empleado as username, puesto as authority FROM authorities WHERE id_Empleado = ?";
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(usersByUsernameQuery);
        users.setAuthoritiesByUsernameQuery(authsByUsernameQuery);
        return users;
    }

    @SuppressWarnings({ "deprecation", "removal" })
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(requests -> requests
                    .requestMatchers("/login", "/static/**", "h2-console/**").permitAll()
                    .anyRequest().permitAll()
            )
            .formLogin(login -> login
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
            )
            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            )
            .exceptionHandling(handling -> handling
                    .accessDeniedPage("/login")
            )
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions().disable());

        return http.build();
    }
}
