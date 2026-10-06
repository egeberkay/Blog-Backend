package com.egeberkayyesil.blog.controllers;

import com.egeberkayyesil.blog.domain.dto.AuthResponse;
import com.egeberkayyesil.blog.domain.dto.LoginRequest;
import com.egeberkayyesil.blog.services.AuthenticationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationServices authenticationServices;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
       UserDetails userDetails = authenticationServices.
               authenticate(loginRequest.getEmail(), loginRequest.getPassword());
       String tokenValue = authenticationServices.generateToken(userDetails);
      AuthResponse authResponse = AuthResponse.builder()
               .token(tokenValue)
               .expireIn(86400)
               .build();
      return ResponseEntity.ok(authResponse);
    }
}
