package com.example.examportal.service.impl;

import com.example.examportal.models.User;
import com.example.examportal.models.UserRole;
import com.example.examportal.repository.RoleRepository;
import com.example.examportal.repository.UserRepository;
import com.example.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    // creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
       User local= this.userRepository.findByUsername(user.getUsername());
       if(local!=null){
           System.out.println("User Already there");
           throw new Exception("User Already present");

       } else {
           // create user
           for (UserRole ur:userRoles)
           {
               roleRepository.save(ur.getRole());
           }
           user.getUserRoles().addAll(userRoles);
           local=this.userRepository.save(user);

       }
        return local;
    }

    // Getting user by username
    @Override
    public User getUser(String username) {
       return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {

        this.userRepository.deleteById(userId);
    }
}
