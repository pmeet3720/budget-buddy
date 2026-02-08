package com.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.UsersModel;

public interface UsersRepository extends MongoRepository<UsersModel, String>{

	Optional<UsersModel> findByEmail(String email);

}
