package com.micro.pe.securityservice.controller;

import com.micro.pe.securityservice.dto.UserDTO;
import com.micro.pe.securityservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s1/user")
@Slf4j
public class AdminUsers {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<UserDTO> getUserByEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            email = userDetails.getUsername();
        }

        log.info("User email: {}", email);

        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok(new UserDTO(user.getId(), user.getEmail(), user.getName(), user.getRole())))
                .orElse(ResponseEntity.notFound().build());
    }
}
