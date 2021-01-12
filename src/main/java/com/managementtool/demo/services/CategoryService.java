package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.Category;
import com.managementtool.demo.repository.CategoryRepository;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

   /*  public void deleteCategory(int id) {

        categoryRepository.deleteCategoryFromDatabase(id);
    }

    public Category getCategoryByID(int idCategory) {
        return categoryRepository.selectCategoryFromDatabase(idCategory);
    }
*/


    /**
     * Sender en liste med allCategorys.
     * @return
     */
    public List<Category> getAllCategorys() {

        List<Category> allCategorys = categoryRepository.selectAllCategorysFromDatabase();

        return allCategorys;
    }

    /**
     * Tilføjer
     * @param category
     * @return
     */
    public void insertProjectIdToCategory(Category category) {
        categoryRepository.insertProjectIdToCategoryDatabase(category);
    }

    /**
     * Gemmer en category i databasen.
     * @param category
     */
    public void insertNewcategory(Category category) {
        categoryRepository.insertCategoryIntoDatabase(category);
    }
}
