package com.parcial2.Parqueadero.config;

import com.parcial2.Parqueadero.services.UsuarioDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UsuarioDetailsService usuarioDetailsService;
    private final CustomLoginSuccessHandler successHandler;

    public SecurityConfig(UsuarioDetailsService usuarioDetailsService,
                          CustomLoginSuccessHandler successHandler) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.successHandler = successHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .userDetailsService(usuarioDetailsService)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/css/**",

                                // Swagger
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api-docs/**"

                        ).permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                        .requestMatchers("/acomodador/**").hasRole("ACOMODADOR")
                        .requestMatchers("/cliente/**").hasRole("CLIENTE")

                        .anyRequest().authenticated()
                )

                .formLogin(login -> login
                        .loginPage("/")
                        .loginProcessingUrl("/login")
                        .successHandler(successHandler)
                        .failureUrl("/?error=true")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
}