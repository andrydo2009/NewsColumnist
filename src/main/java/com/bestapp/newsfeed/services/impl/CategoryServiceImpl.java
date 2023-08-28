package com.bestapp.newsfeed.services.impl;

import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.repositories.CategoryRepository;
import com.bestapp.newsfeed.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Creating an object of the Category class and saving it to the database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#save(Object)}
     * @param category Category class object can not be null
     * @return created Category class object
     */
    @Override
    public Category createCategory(Category category) {
        logger.info("Create category method was invoked");
        categoryRepository.save(category);
        logger.info("Category {} was created successfully", category);
        return category;
    }

    /**
     * Getting the collection of Category objects from database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}
     * @return collection of Category class objects
     */
    @Override
    public Collection<Category> findAllCategories() {
        logger.info("Find all categories method was invoked");
        Collection<Category> categories = categoryRepository.findAll();
        logger.info("All categories was successfully found");
        return categories;
    }

    /**
     * Updating an object of the Category class and saving it to the database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#save(Object)}
     * @param category class Category object can not be null
     * @return updated Category class object
     */
    @Override
    public Category updateCategory(Category category) {
        logger.info("Update category: {} method was invoked", category);
        categoryRepository.save(category);
        logger.info("Category {} was updated successfully", category);
        return category;
    }

    /**
     * Deleting an object of the Category class by its number
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#deleteById(Object)}
     * @param categoryId identification number of Category class object can not be null
     */
    @Override
    public void deleteCategoryById(Long categoryId) {
        logger.info("Delete category by id = {} method was invoked", categoryId);
        categoryRepository.deleteById(categoryId);
        logger.info("Category with id = {} was deleted successfully", categoryId);
    }
}
