package org.example.auth_back_end.controller;

import lombok.RequiredArgsConstructor;
import org.example.auth_back_end.dto.ApiResponse;
import org.example.auth_back_end.dto.AuthDto;
import org.example.auth_back_end.dto.RegisterDto;
import org.example.auth_back_end.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody RegisterDto registerDTO) {
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "User registered successfully",
                        authService.register(registerDTO)
                )
        );
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody AuthDto AuthDTO) {
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "User logged in successfully",
                        authService.authenticate(AuthDTO)
                )
        );
    }
}
