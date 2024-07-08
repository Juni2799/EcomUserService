package com.example.EcomUserService.mappers;

import com.example.EcomUserService.dtos.RoleResponseDTO;
import com.example.EcomUserService.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {
    @Mapping(target = "role", source = "role.roleName")
    @Mapping(target = "desc", source = "role.description")
    RoleResponseDTO RoleToRoleResponseDTO(Role role);

    @Mapping(target = "roleName", source = "roleResponseDTO.role")
    @Mapping(target = "description", source = "roleResponseDTO.desc")
    Role RoleResponseDtoToRole(RoleResponseDTO roleResponseDTO);
}
