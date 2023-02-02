package com.example.examportal;

import com.example.examportal.models.Role;
import com.example.examportal.models.User;
import com.example.examportal.models.UserRole;
import com.example.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

//		User user = new User();
//		user.setFirstName("Sajal");
//		user.setLastName("Ahmed");
//		user.setUsername("Sajal1919");
//
//		user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//
//		user.setEmail("sajal@gmail.com");
//		user.setProfile("default.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		User user1=this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}


}