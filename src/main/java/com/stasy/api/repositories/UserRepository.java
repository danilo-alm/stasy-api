package com.stasy.api.repositories;

import com.stasy.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
     Optional<User> findByLogin(String login);
}
