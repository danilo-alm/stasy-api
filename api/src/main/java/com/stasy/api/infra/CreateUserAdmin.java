package com.stasy.api.infra;

import com.stasy.api.domain.user.UserRole;
import com.stasy.api.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserAdmin {
    @Value("${api.security.admin.username}")
    private String adminUserName;

    @Value("${api.security.admin.password}")
    private String adminUserPassword;
    private static final Logger log = LoggerFactory.getLogger(CreateUserAdmin.class);

    @Bean
    CommandLineRunner initDatabase(UserService userService) {
        return args -> {
            if (userService.getAllUsers().isEmpty()) {
                log.info("Creating admin user");
                userService.createUser(adminUserName, adminUserPassword, UserRole.ADMIN);
            } else log.info("Admin user already exists");
        };
    }
}
