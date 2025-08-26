package com.payoyo.gestionusuarios.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payoyo.gestionusuarios.dto.AuthenticationRequest;
import com.payoyo.gestionusuarios.dto.AuthenticationResponse;
import com.payoyo.gestionusuarios.dto.RegisterRequest;
import com.payoyo.gestionusuarios.entity.Role;
import com.payoyo.gestionusuarios.entity.Usuario;
import com.payoyo.gestionusuarios.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(request.getRol() != null ? request.getRol() : Role.USER)
                .build();

        usuarioRepository.save(usuario);

        var jwtToken = jwtService.generateToken(usuario.getEmail());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        var usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var jwtToken = jwtService.generateToken(usuario.getEmail());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    
}
