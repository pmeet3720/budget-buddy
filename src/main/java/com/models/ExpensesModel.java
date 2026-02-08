package com.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Document(collection="expenses")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpensesModel {
	
	@Id
	String id;
	
	String userId;
	String title;
	Double amount;
	String categoryId;
	LocalDate createdAt;
	String note;

}
