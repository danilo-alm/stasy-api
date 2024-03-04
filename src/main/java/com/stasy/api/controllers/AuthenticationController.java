package com.stasy.api.controllers;

import com.stasy.api.dtos.LoginRequestDTO;
import com.stasy.api.dtos.LoginResponseDTO;
import com.stasy.api.dtos.RegisterDTO;
import com.stasy.api.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
		authService.register(data.login(), data.password(), data.role());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}

