package ro.touristzone.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;

public class CustomTokenEnhancerChain extends TokenEnhancerChain {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        return super.enhance(accessToken, authentication);
    }
}