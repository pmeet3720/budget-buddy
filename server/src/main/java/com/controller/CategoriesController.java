package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.CategoriesModel;
import com.repository.CategoriesRepository;

@RestController
@RequestMapping("/api/category")
public class CategoriesController {
	
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@GetMapping("/categories")
	public List<CategoriesModel> getAllCategories(){
		return categoriesRepository.findAllByOrderByNameAsc();
	}

}
