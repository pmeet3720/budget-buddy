package com.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.models.CategoriesModel;

@Repository
public interface CategoriesRepository extends MongoRepository<CategoriesModel, String>{

	List<CategoriesModel> findAllByOrderByNameAsc();

}
