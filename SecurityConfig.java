package bd.edu.seu.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/dashboard",
                                "/orders/save",
                                "/orders/delete/**",
                                "/css/**",
                                "/js/**"
                        ).permitAll()

                        .requestMatchers("/orders/delete/" ,
                                "/orders/save").hasRole("ADMIN")
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}