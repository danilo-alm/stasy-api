package com.stasy.api.controllers.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.Views;
import com.stasy.api.domain.user.User;
import com.stasy.api.infra.ApiConstants;
import com.stasy.api.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ApiConstants.USER_BASE_URI)
public class UserController {
    private UserService service;

    @GetMapping
    @JsonView(Views.QueryingUsers.class)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
