package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.Category;
import com.managementtool.demo.repository.CategoryRepository;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

    public void deleteCategory(int id) {

        categoryRepository.deleteCategoryFromDatabase(id);
    }

    public Category getCategoryByID(int idCategory) {
        return categoryRepository.selectCategoryFromDatabase(idCategory);
    }

    public List<Category> getAllCategorys() {

        List<Category> allCategorys = categoryRepository.selectAllCategorysFromDatabase();

        return allCategorys;
    }

    public void insertProjectIdToCategory(Category category) {
        categoryRepository.insertProjectIdToCategoryDatabase(category);
    }     

    public void insertNewcategory(Category category) {
        categoryRepository.insertCategoryIntoDatabase(category);
    }
}
