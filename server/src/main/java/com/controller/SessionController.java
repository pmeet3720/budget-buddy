package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginDTO;
import com.models.UsersModel;
import com.repository.UsersRepository;
import com.security.JWTUtil;

@RestController
@RequestMapping("/api/public")
public class SessionController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody UsersModel user){
		Optional<UsersModel> op =  usersRepository.findByEmail(user.getEmail());
		if(op.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
		}
		usersRepository.save(user);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("msg", "User Created Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO dto){
		Optional<UsersModel> op =  usersRepository.findByEmail(dto.getEmail());
		if(op.isPresent()) {
			UsersModel user = op.get();
			if(user.getPassword().equals(dto.getPassword())) {
				//login done
				
				String token = jwtUtil.generateToken(user.getId(), user.getEmail());
				
				Map<String, Object> map = new HashMap<>();
				map.put("token", token);
				map.put("user", user);
				map.put("msg", "login successfull");
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
		}
		Map<String, Object> err = new HashMap<>();
	    err.put("msg", "Invalid email or password");
	    err.put("data", dto);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
		
	}

}
