package jpabook.jpashop.config.oauth.provider;

public interface OAuthUserInfo {
    String getProviderId();

    String getProvider();

    String getEmail();

    String getName();


}
