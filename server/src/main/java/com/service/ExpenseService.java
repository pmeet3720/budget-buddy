package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ExpenseResponseDTO;
import com.models.CategoriesModel;
import com.models.ExpensesModel;
import com.repository.CategoriesRepository;
import com.repository.ExpensesRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpensesRepository expenseRepo;
	
	@Autowired
	CategoriesRepository categoryRepo;

	public List<ExpenseResponseDTO> findExpensesByUserId(String userId) {
		List<ExpensesModel> expenses = expenseRepo.findByUserId(userId);
		return expenses.stream().map(exp->{
			
			ExpenseResponseDTO dto = new ExpenseResponseDTO();
			dto.setId(exp.getId());
			dto.setAmount(exp.getAmount());
			dto.setNote(exp.getNote());
			dto.setTitle(exp.getTitle());
			dto.setCreatedAt(exp.getCreatedAt());
			
			String categoryId = exp.getCategoryId();
			categoryRepo.findById(categoryId).ifPresent(cat-> dto.setCategory(cat.getName()));
			return dto;	
		}).toList();
	}
}
