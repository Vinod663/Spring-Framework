package org.example.auth_back_end.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String role;
}
