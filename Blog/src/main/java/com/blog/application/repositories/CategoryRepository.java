package com.blog.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.application.entities.Category;
import com.blog.application.payloads.CategoryDto;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);

	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	CategoryDto deleteCategory(Integer categoryId);

	// get
	CategoryDto getCategory(Integer categoryId);

	// getAll
	CategoryDto getAllCategory();
}
