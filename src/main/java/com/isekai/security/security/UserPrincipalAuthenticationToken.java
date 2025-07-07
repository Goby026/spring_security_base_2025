package com.isekai.security.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {

    private final UserPrincipal principal;

    public UserPrincipalAuthenticationToken(UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.principal = userPrincipal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return principal;
    }
}
