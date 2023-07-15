package taller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import taller.services.impls.auth.UserDetailsServiceImpl;
import taller.utils.JwtRequestFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Lazy
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    private static final String[] AUTH_WHITELIST = {
        // -- Swagger UI v3 (OpenAPI)
        "/v3/api-docs/**",
        "/swagger-ui/**",
        // other public endpoints of your API may be appended to this array
        "/public/**"
    };

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers("/private/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .cors(withDefaults())
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
        ;

        http.formLogin(withDefaults()); // (1)
        http.httpBasic(withDefaults()); // (1)

        return http.build();
    }

    // Autenticacion con UserDetailsService
    @Bean
    UserDetailsServiceImpl userDetailsService() {

        return new UserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

  /* Autenticacion en Memoria
  @Bean
  public UserDetailsService users() {
    UserDetails user = User.builder()
        .username("user")
        .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
        .roles("USER")
        .build();
    UserDetails admin = User.builder()
        .username("admin")
        .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
        .roles("USER", "ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user, admin);
  }
  */

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }
}
