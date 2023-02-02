package com.example.examportal.service;

import com.example.examportal.models.User;
import com.example.examportal.models.UserRole;

import java.util.Set;

public interface UserService {

    // creating user
    public User createUser(User user , Set<UserRole> userRoles) throws Exception;

    // get user by username
    public User getUser(String username);
    public void deleteUser(Long userId);
}
