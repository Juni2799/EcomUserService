package com.example.EcomUserService.services;

import com.example.EcomUserService.dtos.RoleRequestDTO;
import com.example.EcomUserService.dtos.RoleResponseDTO;
import com.example.EcomUserService.mappers.RoleMapper;
import com.example.EcomUserService.models.Role;
import com.example.EcomUserService.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = roleMapper.RoleRequestDtoToRole(roleRequestDTO);
        return roleMapper.RoleToRoleResponseDTO(roleRepository.save(role));
    }
}
