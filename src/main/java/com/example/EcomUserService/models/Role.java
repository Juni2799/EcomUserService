package com.example.EcomUserService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_ROLE")
@Getter
@Setter
public class Role extends BaseModel{
    private String description;
    private String roleName;
}
