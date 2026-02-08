package com.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Roles;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Document(collection="users")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersModel {

	@Id
	String id;
	
	@NonNull
	String firstName;
	
	@NonNull
	String lastName;
	
	@Indexed(unique = true)
	@NonNull
	String email;
	
	@NonNull
	String password;
	
	@NonNull
	String contactNo;
	
	@NonNull
	String gender;
	
	@NonNull
	Roles role;
	
	Boolean status;
	
	@DBRef
	List<ExpensesModel> expenses = new ArrayList<>();
	
}
