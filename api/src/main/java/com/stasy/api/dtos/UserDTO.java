package com.stasy.api.dtos;

import com.stasy.api.domain.user.UserRole;

public record UserDTO(String username, String password, UserRole role) {
}
