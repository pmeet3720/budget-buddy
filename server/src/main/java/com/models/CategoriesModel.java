package com.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Document(collection="categories")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriesModel {
	
	@Id
	String id;
	String name;

}
