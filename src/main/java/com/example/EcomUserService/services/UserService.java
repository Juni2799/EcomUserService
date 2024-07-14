package com.example.EcomUserService.services;

import com.example.EcomUserService.dtos.*;
import com.example.EcomUserService.exceptions.RoleNotFoundException;

public interface UserService {
    UserResponseDTO signup(SignUpRequestDTO signupRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
