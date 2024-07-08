package com.example.EcomUserService.controllers;

import com.example.EcomUserService.dtos.LoginRequestDTO;
import com.example.EcomUserService.dtos.SignUpRequestDTO;
import com.example.EcomUserService.dtos.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserResponseDTO> login(@RequestBody SignUpRequestDTO signUpRequestDTO){
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity validate(){
        return null;
    }
}
