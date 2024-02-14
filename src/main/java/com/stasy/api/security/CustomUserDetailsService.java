package com.stasy.api.security;

import com.stasy.api.domain.user.User;
import com.stasy.api.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login).orElseThrow();
        return UserPrincipal.builder()
          .login(user.getLogin())
          .password(user.getPassword())
          .authorities(List.of(new SimpleGrantedAuthority(user.getRole().name())))
          .password(user.getPassword())
          .build();
    }
}
