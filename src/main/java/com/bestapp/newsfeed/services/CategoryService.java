package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.dto.CategoryDTO;
import com.bestapp.newsfeed.models.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO category);
    Collection<CategoryDTO> findAllCategories();

    CategoryDTO updateCategory(CategoryDTO category);

    void deleteCategoryById(Long categoryId);
    List<Category> getListOfCategoryByPage(Integer number, Integer size);}
