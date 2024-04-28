// package es.upm.dit.isst.factorrh04.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


// @Configuration
// public class SecurityConfiguration {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/h2-console/**").permitAll()
//                 )
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/**").permitAll()
//                 )
//             // cuando tengamos los ususarios y roles hay que añadir la seguridad para que rh pueda acceder  todo
//             // y user solo a home, fichar, pedir bajas, archivos 
//                 /*
//                 protected void configure(HttpSecurity http) throws Exception {
//                 ej: http.authorizeRequests()
//                 .antMatchers("/”).permitAll() (+0.25)
//                 .anyRequest().authenticated() (+0.25)
//                 .and().formLogin().loginPage(“/acceso”).permitAll() (+0.25)
//                 .and().logout().permitAll();
//                 */

//                 .headers(headers -> headers.frameOptions().disable())
//                 .csrf(csrf -> csrf
//                         .ignoringRequestMatchers("/h2-console/**"));
//         return http.build();
//     }
// }

package es.upm.dit.isst.factorrh04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> {
                authorizeRequests
                    .requestMatchers("/login").permitAll()
                    .anyRequest().authenticated();
            })
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true) // Redireccionar al usuario a home después de iniciar sesión
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .exceptionHandling().accessDeniedPage("/login");
        return http.build();
    }
}
