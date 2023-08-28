package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Collection<Category> findAllCategories();

    Category updateCategory(Category category);

    void deleteCategoryById(Long categoryId);
    List<Category> getListOfCategoryByPage(Integer number, Integer size);}
