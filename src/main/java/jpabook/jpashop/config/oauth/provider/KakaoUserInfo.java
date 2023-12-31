package jpabook.jpashop.config.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements OAuthUserInfo {

    private Map<String,Object> attribute;

    public KakaoUserInfo(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getProviderId() {
        return (String) attribute.get("id");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return (String) attribute.get("email");
    }

    @Override
    public String getName() {
        return (String) attribute.get("nickname");
    }


}
