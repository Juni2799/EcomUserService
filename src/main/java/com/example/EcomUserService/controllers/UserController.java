package com.example.EcomUserService.controllers;

import com.example.EcomUserService.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity login(){
        return null;
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @PostMapping("/signUp")
    public ResponseEntity login(User user){
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity validate(){
        return null;
    }
}
