package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.models.Category;

import java.util.Collection;

public interface CategoryService {
    Category createCategory(Category category);
    Collection<Category> findAllCategories();
    Category updateCategory(Category category);
    void deleteCategoryById(Long categoryId);
}
