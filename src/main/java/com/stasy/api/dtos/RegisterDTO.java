package com.stasy.api.dtos;

import com.stasy.api.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
