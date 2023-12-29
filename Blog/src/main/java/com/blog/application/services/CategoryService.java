package com.blog.application.services;

import java.util.List;

import com.blog.application.payloads.CategoryDto;

public interface CategoryService {
	
	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// get single category.
	
	CategoryDto getCategory(Integer categoryId);
	
	// get all categories
	
	List<CategoryDto> getCategories();
	
	// delete category
	
	void deleteCategory(Integer categoryId);

}
