package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.models.ExpensesModel;

@Repository
public interface ExpensesRepository extends MongoRepository<ExpensesModel, String>{

}
