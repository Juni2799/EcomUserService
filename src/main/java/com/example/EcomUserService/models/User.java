package com.example.EcomUserService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_USER")
public class User extends BaseModel{
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    @ManyToMany
    private List<Role> roles;
}
