package com.example.examportal.controller;

import com.example.examportal.models.Role;
import com.example.examportal.models.User;
import com.example.examportal.models.UserRole;
import com.example.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");

        // encoding password with bcryptpassword encoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));



        Set<UserRole> roles=new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }
    // Delete User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){

        this.userService.deleteUser(userId);
    }
}
