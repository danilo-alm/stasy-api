package com.stasy.api.controllers.product;

import com.stasy.api.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this, you're logged in as user " +
          principal.getUsername() + ";Authorities: " + principal.getAuthorities();
    }
}
