package com.micro.pe.securityservice.controller;

import com.micro.pe.securityservice.dto.*;
import com.micro.pe.securityservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.naming.NamingException;

@RestController
@RequestMapping("api/s1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }

    @PostMapping("/signin")
    public SigninResponse signIn(@RequestBody SignInRequest signInRequest) throws NamingException {
        return authService.signIn(signInRequest);
    }

    @PostMapping("/refresh")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest token){
        return authService.refreshToken(token);
    }
}
