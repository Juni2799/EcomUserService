package com.example.EcomUserService.mappers;

import com.example.EcomUserService.dtos.UserResponseDTO;
import com.example.EcomUserService.models.User;
import org.mapstruct.Mapper;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {
    User UserResponseDtoToUser(UserResponseDTO userResponseDTO);

    UserResponseDTO UserToUserResponseDTO(User user);
}
