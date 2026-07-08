package com.project.EcommerceHub.service;

import com.project.EcommerceHub.exceptions.APIException;
import com.project.EcommerceHub.exceptions.ResourceNotFoundException;
import com.project.EcommerceHub.model.Category;
import com.project.EcommerceHub.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw  new APIException("No Category created till now !");
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null)
            throw new APIException("Category with name " + category.getCategoryName()+ " already exists");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID",categoryId));

        categoryRepository.delete(category);
        return "Category with categoryID " + category.getCategoryId() + " has been deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory= categoryRepository.findById(categoryId)
                .orElseThrow(() ->  new ResourceNotFoundException("Category", "CategoryID",categoryId));
        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory;
    }
}
