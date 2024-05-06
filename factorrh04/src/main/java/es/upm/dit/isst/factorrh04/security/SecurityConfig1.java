package es.upm.dit.isst.factorrh04.security;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig1 {

//     @Autowired
//     private DataSource dataSource;

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//     }

//     @Bean
//     public UserDetailsService jbdcUserDetailsService(DataSource dataSource) {
//         String usersByUsernameQuery = "SELECT email as username, password FROM Empleado WHERE email = ?";
//         String authsByUsernameQuery = "SELECT email as username, authority FROM authorities WHERE email = ?";
//         JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//         users.setUsersByUsernameQuery(usersByUsernameQuery);
//         users.setAuthoritiesByUsernameQuery(authsByUsernameQuery);
//         return users;
//     }

//     @SuppressWarnings({ "deprecation", "removal" })
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests(requests -> requests
//                     .requestMatchers("/login", "/static/**", "/h2-console/**").permitAll()
//                     .anyRequest().permitAll()
//             )
//             .formLogin(login -> login
//                     .loginPage("/login")
//                     .defaultSuccessUrl("/")
//                     .permitAll()
//             )
//             .logout(logout -> logout
//                     .logoutSuccessUrl("/login?logout")
//                     .permitAll()
//             )
//             .exceptionHandling(handling -> handling
//                     .accessDeniedPage("/login")
//             )
//             .csrf(csrf -> csrf.disable())
//             .headers(headers -> headers.frameOptions().disable());

//         return http.build();
//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig1 {

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public HttpStatusReturningLogoutSuccessHandler logoutSuccessHandler() {
        return new HttpStatusReturningLogoutSuccessHandler();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Definir usuarios en memoria para pruebas
        return new InMemoryUserDetailsManager(
            User.withUsername("alvarocolin")
                .password("{noop}pass")
                .roles("USER")
                .build(),
            User.withUsername("guillermoazcoitia")
                .password("{noop}pass")
                .roles("ADMIN")
                .build());
    }

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/login", "/static/**", "/h2-console/**").permitAll()
                    .requestMatchers("/home_rh").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .successHandler(myAuthenticationSuccessHandler())
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessHandler(logoutSuccessHandler())
                    .permitAll()
            )
            .exceptionHandling(exceptionHandling ->
                exceptionHandling
                    .accessDeniedPage("/login")
            )
            .csrf(csrf ->
                csrf.disable()
            )
            .headers(headers ->
                headers.frameOptions().disable()
            );

        return http.build();
    }

    private static class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails.getUsername().equals("guillermoazcoitia")) {
                return "/home_rh"; // Redirigir a /home_rh si es guillermoazcoitia
            }
            return super.determineTargetUrl(request, response, authentication);
        }
    }
}
