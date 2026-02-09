package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.ExpensesModel;
import com.repository.ExpensesRepository;

@RestController
@RequestMapping("/api/expense")
public class ExpensesController {
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	@GetMapping("/expenses")
	public List<ExpensesModel> getAllExpenses(){
		return expensesRepository.findAll();
	}

}
