package com.darine.entreprises.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.configurationSource(request -> {
					CorsConfiguration configuration = new CorsConfiguration();
					configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
					configuration.setAllowedMethods(Collections.singletonList("*"));
					configuration.setAllowedHeaders(Collections.singletonList("*"));
					configuration.setExposedHeaders(Collections.singletonList("Authorization"));
					return configuration;
				}))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.GET, "/api", "/api/**")
						.permitAll()
						.requestMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN")
						.requestMatchers(HttpMethod.PATCH, "/**").hasAuthority("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN")
						.anyRequest().authenticated())
				.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
