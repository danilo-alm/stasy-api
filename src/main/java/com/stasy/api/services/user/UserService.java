package com.stasy.api.services.user;

import com.stasy.api.domain.user.User;
import com.stasy.api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
