package com.project.EcommerceHub.model;

public class Category {
    String CategoryName;
    Long CategoryId;

    public Category(String CategoryName, Long CategoryId) {
        this.CategoryName = CategoryName;
        this.CategoryId = CategoryId;

    }
    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
}
