/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.am.gateway.handler.oauth2.token;

import io.gravitee.oauth2.repository.oauth2.api.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Titouan COMPIEGNE (titouan.compiegne at graviteesource.com)
 * @author GraviteeSource Team
 */
@Component
public class TokenStore implements org.springframework.security.oauth2.provider.token.TokenStore{

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return tokenRepository.readAuthentication(convert(token));
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        return tokenRepository.readAuthentication(token);
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        tokenRepository.storeAccessToken(convert(token), convert(authentication));
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        return tokenRepository.readAccessToken(tokenValue);
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        tokenRepository.removeAccessToken(convert(token));
    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        tokenRepository.storeRefreshToken(convert(refreshToken), convert(authentication));
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        return tokenRepository.readRefreshToken(tokenValue);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        return tokenRepository.readAuthenticationForRefreshToken(convert(token));
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        tokenRepository.removeRefreshToken(convert(token));
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        tokenRepository.removeAccessTokenUsingRefreshToken(convert(refreshToken));
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        return tokenRepository.getAccessToken(convert(authentication));
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        // TODO
        return Collections.emptyList();
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        // TODO
        return Collections.emptyList();
    }

    private io.gravitee.oauth2.repository.oauth2.model.OAuth2AccessToken convert(OAuth2AccessToken _oAuth2AccessToken) {
        return new io.gravitee.oauth2.repository.oauth2.model.OAuth2AccessToken(_oAuth2AccessToken);
    }

    private OAuth2AccessToken convert(io.gravitee.oauth2.repository.oauth2.model.OAuth2AccessToken oAuth2AccessToken) {
        return null;
    }

    private io.gravitee.oauth2.repository.oauth2.model.OAuth2RefreshToken convert(OAuth2RefreshToken _oAuth2RefreshToken) {
        return new io.gravitee.oauth2.repository.oauth2.model.OAuth2RefreshToken(_oAuth2RefreshToken.getValue());
    }

    private OAuth2RefreshToken convert(io.gravitee.oauth2.repository.oauth2.model.OAuth2RefreshToken oAuth2AccessToken) {
        return null;
    }

    private io.gravitee.oauth2.repository.oauth2.model.OAuth2Authentication convert(OAuth2Authentication _oAuth2Authentication) {
        return new io.gravitee.oauth2.repository.oauth2.model.OAuth2Authentication(_oAuth2Authentication.getOAuth2Request(), _oAuth2Authentication.getUserAuthentication());
    }

    private OAuth2Authentication convert(io.gravitee.oauth2.repository.oauth2.model.OAuth2Authentication oAuth2AccessToken) {
        return null;
    }
}
