package jpabook.jpashop.configuration;

import jpabook.jpashop.domain.MemberRole;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {



        private  final  MemberService memberService;
        private final MemberRepository memberRepository;



    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf(c-> c.disable())
                    .cors(c -> c.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/user/**").authenticated()
                            .requestMatchers("/manager/**").hasAuthority("MANAGER")
                            .requestMatchers("/admin/**").hasAuthority("ADMIN")
                            .anyRequest().permitAll()
                           );
//                    .oauth2Login(oaut2 -> oaut2
//                            .loginPage("/")
//                            .authorizationEndpoint(authorization -> authorization
//                                    .baseUri("/login/oauth/authorization")
//                            )
//
//                    );






            return http.build();
        }


}


