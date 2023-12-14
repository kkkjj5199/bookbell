package jpabook.jpashop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class AuthenticationConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /* requestMatchers(new AntPathRequestMatchers()) : 특정 리소스에 대해서 권한 설정
           permitAll() : requestMatchers 설정한 리소스 접근을 인증절차 없이 허용
           hasAnyRole() : 리소스에 대한 모든 URL은 인증 후 특정 레벨의 권한 사용자만 접근 허용

        */

         return http.formLogin()
                 .loginPage("/api/v1/members/login")
                 .defaultSuccessUrl("/api/v1/members/login-success")
                 .defaultSuccessUrl("/")
                 .failureUrl("/login-fail")
                 .and().build();



    }
}
