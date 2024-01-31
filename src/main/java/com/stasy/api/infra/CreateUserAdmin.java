package com.stasy.api.infra;

import com.stasy.api.domain.user.User;
import com.stasy.api.domain.user.UserRole;
import com.stasy.api.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CreateUserAdmin {
    @Value("${api.security.admin.username}")
    private String adminUserName;

    @Value("${api.security.admin.password}")
    private String adminUserPassword;
    private static final Logger log = LoggerFactory.getLogger(CreateUserAdmin.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            if (repository.findAll().isEmpty()) {
                log.info("Creating admin user");
                String encryptedPassword = new BCryptPasswordEncoder().encode(adminUserPassword);
                repository.save(new User(adminUserName, encryptedPassword, UserRole.ADMIN));
            } else log.info("Admin user already exists");
        };
    }
}
