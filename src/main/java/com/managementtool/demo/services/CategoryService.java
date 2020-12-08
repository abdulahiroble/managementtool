package com.managementtool.demo.services;

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
}
