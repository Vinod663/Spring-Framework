package org.example.auth_back_end.service;

import lombok.RequiredArgsConstructor;
import org.example.auth_back_end.dto.AuthDto;
import org.example.auth_back_end.dto.AuthResponseDto;
import org.example.auth_back_end.dto.RegisterDto;
import org.example.auth_back_end.entity.Role;
import org.example.auth_back_end.entity.User;
import org.example.auth_back_end.repository.UserRepository;
import org.example.auth_back_end.utill.JwtUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // This annotation indicates that this class is a service component in the Spring context.
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDto authenticate(AuthDto authDTO){

        User user = userRepository.findByUsername(authDTO.getUsername()).orElseThrow(()->new RuntimeException("User not found"));

        if (!passwordEncoder.matches(authDTO.getPassword(),user.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(authDTO.username);
        return new AuthResponseDto(token);
    }


    public String register(RegisterDto registerDto) {
    if (userRepository.findByUsername(registerDto.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = User.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .role(Role.valueOf(registerDto.getRole().toUpperCase())) // Assuming Role is an enum
                .build();
        userRepository.save(user);
        return "User registered successfully";

    }
}
