package com.project.EcommerceHub.service;

import com.project.EcommerceHub.model.Category;
import com.project.EcommerceHub.payload.CategoryDTO;
import com.project.EcommerceHub.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
   CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long CategoryId);
}
