// package es.upm.dit.isst.factorrh04.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(auth -> {
//                     auth.requestMatchers("/").permitAll();
//                 })
//                 .formLogin(form -> form.loginPage("/login").permitAll());
//         return http.build();
//     }
// }

package es.upm.dit.isst.factorrh04.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //PREGUNTAR LO DEL PASSWORDENCONDER
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // }


    // @Bean
    // //Configuracion lectura de credenciales desde esquema estandar
    // public UserDetailsService jbdcUserDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder) {
    //     String usersByUsernameQuery = "select username, password, enabled from users where username = ?";
    //     String authsByUserQuery = "select username, authority from authorities where username = ?";
    //     JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    //     users.setUsersByUsernameQuery(usersByUsernameQuery);
    //     users.setAuthoritiesByUsernameQuery(authsByUserQuery);
    //     return users;
    // }


    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> {
                    csrf.disable();
                })
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/static/**").permitAll()
                            .anyRequest().authenticated();
                })
                
                .formLogin(form -> form
                                .loginPage("/login") // Especificar la página de inicio de sesión personalizada
                                .permitAll() // Permitir acceso a la página de inicio de sesión
                                .defaultSuccessUrl("/", true) // Redirigir al usuario a home después de iniciar sesión
                )
                .logout(logout -> logout
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                )
                .exceptionHandling(handling -> handling.accessDeniedPage("/login"));

            //Deshabilitamos proteccion X-Frame-Options
            http.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));
        return http.build();
    }
}