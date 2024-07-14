package com.example.EcomUserService.services;

import com.example.EcomUserService.dtos.LoginRequestDTO;
import com.example.EcomUserService.dtos.SignUpRequestDTO;
import com.example.EcomUserService.dtos.UserResponseDTO;
import com.example.EcomUserService.exceptions.InvalidCredentialException;
import com.example.EcomUserService.exceptions.RoleNotFoundException;
import com.example.EcomUserService.exceptions.UserNotFoundException;
import com.example.EcomUserService.mappers.UserMapper;
import com.example.EcomUserService.models.Role;
import com.example.EcomUserService.models.User;
import com.example.EcomUserService.repositories.RoleRepository;
import com.example.EcomUserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignUpRequestDTO signupRequestDTO) throws RoleNotFoundException {
        Role savedRole = roleRepository.findById(signupRequestDTO.getRoleId())
                .orElseThrow(() -> new RoleNotFoundException("No role found!!"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        user.setRoles(List.of(savedRole));

        return userMapper.UserToUserResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User savedUser = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found!!"));

        if(bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword())){
            String userData = savedUser.getEmail() + savedUser.getPassword() + LocalDateTime.now();
            String token = bCryptPasswordEncoder.encode(userData);
            savedUser.setToken(token);
        }else{
            throw new InvalidCredentialException("Incorrect Password!!");
        }
        savedUser = userRepository.save(savedUser);
        return userMapper.UserToUserResponseDTO(savedUser);
    }

    @Override
    public boolean validateToken(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialException("Token is not valid")
        );
        return true;
    }

    @Override
    public boolean logout(String token) {
        User savedUser = userRepository.findByToken(token)
                .orElseThrow(() -> new InvalidCredentialException("Incorrect token!!"));
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
