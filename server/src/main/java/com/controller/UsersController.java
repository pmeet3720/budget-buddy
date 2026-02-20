package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.UsersModel;
import com.repository.UsersRepository;

@RestController
@RequestMapping("/api/admin/user")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/users")
	public List<UsersModel> getAllUsers(){
		return usersRepository.findAll();
	}

}
