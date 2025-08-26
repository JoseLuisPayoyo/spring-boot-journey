package com.payoyo.gestion_cursos.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payoyo.gestion_cursos.dto.AuthRequest;
import com.payoyo.gestion_cursos.dto.AuthResponse;
import com.payoyo.gestion_cursos.dto.RegisterRequest;
import com.payoyo.gestion_cursos.entity.Role;
import com.payoyo.gestion_cursos.entity.Usuario;
import com.payoyo.gestion_cursos.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request){
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Role.USER)
                .build();
                
        usuarioRepository.save(usuario);
        String token = jwtService.generateToken(usuario.getEmail());
        
        return new AuthResponse(token);
    }

    public AuthResponse authenticate(AuthRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generateToken(usuario.getEmail());
        
        return new AuthResponse(token);
    }
}
