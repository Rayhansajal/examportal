package com.example.examportal.repository;

import com.example.examportal.models.Role;
import com.example.examportal.models.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long> {
}
