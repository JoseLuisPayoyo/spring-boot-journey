package com.payoyo.gestionusuarios.controller;

import com.payoyo.gestionusuarios.auth.AuthenticationService;
import com.payoyo.gestionusuarios.dto.AuthenticationRequest;
import com.payoyo.gestionusuarios.dto.AuthenticationResponse;
import com.payoyo.gestionusuarios.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/registro")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
