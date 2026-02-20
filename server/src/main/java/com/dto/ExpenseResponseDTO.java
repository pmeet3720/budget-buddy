package com.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseResponseDTO {
	
	private String id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate createdAt;
    private String note;

}
