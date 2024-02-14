package com.stasy.api.services.user;

import com.stasy.api.domain.user.User;
import com.stasy.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    public void save(User user) {
        repository.save(user);
    }
}
