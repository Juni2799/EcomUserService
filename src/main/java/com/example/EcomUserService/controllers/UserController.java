package com.example.EcomUserService.controllers;

import com.example.EcomUserService.dtos.LoginRequestDTO;
import com.example.EcomUserService.dtos.SignUpRequestDTO;
import com.example.EcomUserService.dtos.UserResponseDTO;
import com.example.EcomUserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorisation") String authToken){
        return ResponseEntity.ok(userService.logout(authToken));
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        return ResponseEntity.ok(userService.signup(signUpRequestDTO));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorisation") String authToken){
        return ResponseEntity.ok(userService.validateToken(authToken));
    }
}
