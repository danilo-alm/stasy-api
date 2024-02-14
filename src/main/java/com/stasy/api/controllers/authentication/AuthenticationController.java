package com.stasy.api.controllers.authentication;

import com.stasy.api.dtos.LoginRequestDTO;
import com.stasy.api.dtos.LoginResponseDTO;
import com.stasy.api.dtos.RegisterDTO;
import com.stasy.api.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stasy.api.infra.ApiConstants;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.AUTHENTICATION_BASE_URI)
public class AuthenticationController {
	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
		LoginResponseDTO response = authService.attemptLogin(request.login(), request.password());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
		try {
			authService.register(data.login(), data.password(), data.name(), data.role());
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

