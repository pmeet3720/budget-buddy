package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.ExpensesModel;
import com.service.ExpenseService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/expense")
public class ExpensesController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public ResponseEntity<?> getAllExpenses(HttpServletRequest request){
		String userId = request.getAttribute("userId").toString();
		System.out.println(userId);
		List<?> expenses = expenseService.findExpensesByUserId(userId);
		Map<String, Object> response = new HashMap<>();
		response.put("msg","Data fetched successfully");
		response.put("Data", expenses);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
