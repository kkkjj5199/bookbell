package jpabook.jpashop.config.oauth;

import java.util.Map;
import java.util.Optional;

import jpabook.jpashop.config.auth.PrincipalDetails;
import jpabook.jpashop.config.oauth.provider.GoogleUserInfo;
import jpabook.jpashop.config.oauth.provider.NaverUserInfo;
import jpabook.jpashop.config.oauth.provider.OAuthUserInfo;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.MemberRole;
import jpabook.jpashop.repository.LoginRepository;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {


   @Autowired
   private MemberRepository memberRepository;
    @Autowired
    private LoginRepository loginRepository;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println("userRequest clientReisgration : " + userRequest.getClientRegistration());

        System.out.println("oAuth2User : " + oAuth2User);

        return processOAuth2User(userRequest,oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        OAuthUserInfo oAuthUserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글 로그인");
            oAuthUserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인");
            oAuthUserInfo = new NaverUserInfo( (Map)oAuth2User.getAttributes().get("response") );

        }

        Optional<Member> userOptional = loginRepository.findByProviderAndProviderId(oAuthUserInfo.getProvider(), oAuthUserInfo.getProviderId());

        Member member;

        if(userOptional.isPresent()){
            member = userOptional.get();
            memberRepository.save(member);

        }else{
            member = Member.builder()

                    .name(oAuthUserInfo.getProvider() + "_" + oAuthUserInfo.getProviderId())
                    .email(oAuthUserInfo.getEmail())
                    .role(MemberRole.valueOf("ROLE_USER"))
                    .provider(oAuthUserInfo.getProvider())
                    .providerId(oAuthUserInfo.getProviderId())
                    .build();
            memberRepository.save(member);
        }
        return  new PrincipalDetails(member,oAuth2User.getAttributes());
    }
}
