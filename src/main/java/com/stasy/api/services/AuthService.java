package com.stasy.api.services;

import com.stasy.api.domain.user.User;
import com.stasy.api.domain.user.UserRole;
import com.stasy.api.dtos.LoginResponseDTO;
import com.stasy.api.infra.security.JwtIssuer;
import com.stasy.api.infra.security.UserPrincipal;
import com.stasy.api.services.exceptions.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public LoginResponseDTO attemptLogin(String login, String password) {
        var authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(login, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream()
          .map(GrantedAuthority::getAuthority)
          .toList();

        var token = jwtIssuer.issue(principal.getUsername(), roles);
        return new LoginResponseDTO(token);
    }

    public void register(String login, String password, UserRole role) {
        if (this.userService.getUserByLogin(login).isPresent()) throw new UserAlreadyExistsException(login);

        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        User newUser = new User(login, encryptedPassword, role);

        this.userService.save(newUser);
    }
}
