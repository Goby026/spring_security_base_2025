package com.isekai.security.security;

import com.isekai.security.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userEntityService.findByEmail(username).orElseThrow();

        return UserPrincipal.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .authorities( List.of( new SimpleGrantedAuthority(user.getRole())) )
                .password(user.getPassword())
                .build();
    }
}
