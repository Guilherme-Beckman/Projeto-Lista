package com.beckman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beckman.model.Users;
import com.beckman.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
private UsersService userService;
@Autowired
public UsersController(UsersService userService) {
	this.userService = userService;
}

  
@GetMapping
public List<Users> getAllUsers(){
	return userService.getAllUsers();
}
@GetMapping("/{userId}")
public ResponseEntity<Users> getUserById(@PathVariable Long UserId){
	Users user = userService.getUsersByID(UserId);
	return ResponseEntity.ok(user);
	
}
@PostMapping
public ResponseEntity<Users> createUser (@RequestBody Users user){
	Users savedUser = userService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
}

}
