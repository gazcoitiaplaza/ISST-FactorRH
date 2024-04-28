package es.upm.dit.isst.factorrh04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                )
            // cuando tengamos los ususarios y roles hay que añadir la seguridad para que rh pueda acceder  todo
            // y user solo a home, fichar, pedir bajas, archivos 
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**"));
        return http.build();
    }
}