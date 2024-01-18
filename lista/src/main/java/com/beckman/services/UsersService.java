package com.beckman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beckman.model.Users;
import com.beckman.repositories.UsersRepository;

@Service
public class UsersService {
private final UsersRepository usersRepository;

@Autowired
public UsersService(UsersRepository usersRepository) {

	this.usersRepository = usersRepository;
}
public List<Users> getAllUsers(){
	return usersRepository.findAll();
	}
public Users getUsersByID(Long usersID) {
return usersRepository.findById(usersID).orElse(null);

}
public Users saveUser(Users user) {
    return usersRepository.save(user);
}
}