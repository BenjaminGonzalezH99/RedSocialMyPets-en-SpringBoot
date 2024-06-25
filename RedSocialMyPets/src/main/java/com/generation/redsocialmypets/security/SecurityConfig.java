package com.generation.redsocialmypets.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF (si es necesario)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/usuarios/login").permitAll() // Permitir acceso a login
                        .requestMatchers("/api/usuarios/**").hasRole("ADMIN") // Restringir acceso a ADMIN
                        .anyRequest().authenticated() // Autenticar todas las demás solicitudes
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Página de login
                        .permitAll() // Permitir acceso a la página de login
                )
                .logout(logout -> logout.permitAll() // Permitir acceso a la página de logout
                );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
