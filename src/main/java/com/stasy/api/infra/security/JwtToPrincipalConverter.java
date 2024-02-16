package com.stasy.api.infra.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder()
          .login(jwt.getSubject())
          .authorities(extractAuthoritiesFromJwt(jwt))
          .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromJwt(DecodedJWT jwt) {
        var claim = jwt.getClaim("a");
        return (claim.isNull() || claim.isMissing())
          ? List.of()
          : claim.asList(SimpleGrantedAuthority.class);
    }
}
