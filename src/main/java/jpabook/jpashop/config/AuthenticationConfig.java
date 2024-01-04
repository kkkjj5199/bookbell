package jpabook.jpashop.config;

import jpabook.jpashop.config.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }


    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.csrf(c-> c.disable())

//                    .cors(c -> c.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/user/**").authenticated()
                            .requestMatchers("/admin/**").hasAuthority("ADMIN")
                            .anyRequest().permitAll()
                           )
                    .formLogin(form -> form
//                            .loginPage("/")
                            .loginProcessingUrl("/hello")
                            .defaultSuccessUrl("/hello")
                            .permitAll()
                    )
                    .oauth2Login(oauth2 -> oauth2
                                    .loginPage("/")
                                    .userInfoEndpoint(userInfo -> userInfo
                                            .userService(principalOauth2UserService))
                            );


            return http.build();
        }


}


