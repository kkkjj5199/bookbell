package jpabook.jpashop.config.auth;

import jpabook.jpashop.domain.Member;

import jpabook.jpashop.repository.LoginRepository;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Map;

public class PrincipalDetailsService implements UserDetailsService {


    @Autowired
    MemberRepository memberRepository ;

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = loginRepository.findByName(username);
        if(member == null) {
            return  null;
        }else {
            return  new PrincipalDetails(member);
        }


    }
}
