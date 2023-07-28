package com.example.board.config;

import com.example.board.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(Customizer.withDefaults()) // 기본 설정으로 Cross-Origin Resource Sharing (CORS) 활성화
                .csrf((csrf) -> csrf.disable()) // Cross-Site Request Forgery (CSRF) 보호 비활성화
                .httpBasic((httpBasic) -> httpBasic.disable()) // HTTP Basic 인증 비활성화
                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 생성 정책을 STATELESS로 설정하여 세션 미사용
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .antMatchers("/", "/api/auth/**").permitAll() // 루트와 /api/auth/** 엔드포인트의 요청에 대해 인증 없이 허용
                        .anyRequest().authenticated()); // 그 외의 요청에 대해 인증이 필요함

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // 사용자 정의 JWT 인증 필터를 UsernamePasswordAuthenticationFilter 이전에 추가

        return httpSecurity.build();
    }
}
