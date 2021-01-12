package com.managementtool.demo.repository;

import com.managementtool.demo.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    /**
     * Indsætter en ny manager i databasen.
     * @param category
     * */
    public void insertCategoryIntoDatabase(Category category) {
        String insertCategorySQL = "INSERT INTO category (categoryname) VALUES (?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertCategorySQL);
            preparedStatement.setString(1, category.getCategoryname());


            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        /**
     * Indsætter projectid i category databasen.
     * @param category
     * */
    public void insertProjectIdToCategoryDatabase(Category category) {
        String insertUserSQL = "UPDATE category, project SET projectid = idproject";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        /**
     * Vælger alle categorier i databasen og returnerer dem som en ArrayList.
     * */
    public List<Category> selectAllCategorysFromDatabase() {

        String selectAllCategory = "SELECT (categoryname) FROM category INNER JOIN project ON idproject = projectid WHERE idcategory = 1";

        List<Category> allCategory = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllCategory);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Category tmpProject = new Category(resultSet.getString(1));
                allCategory.add(tmpProject);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allCategory;
    }

    // public Category selectCategoryFromDatabase(int idCategory) {

    //     Category categoryToReturn = new Category();

    //     String selectCategory = "SELECT * FROM category WHERE idcategory = ?";

    //     try {
    //         PreparedStatement preparedStatement = establishConnection().prepareStatement(selectCategory);
    //         preparedStatement.setInt(1, idCategory);

    //         ResultSet resultSet = preparedStatement.executeQuery();

    //         while (resultSet.next()) {
    //             categoryToReturn = new Category(resultSet.getInt(1), resultSet.getString(2));
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return categoryToReturn;
    // }

    // public void deleteCategoryFromDatabase(int idCategory){
    //     String deleteCategorySQL = "DELETE FROM category WHERE idcategory = ?";
    //     try {
    //         PreparedStatement preparedStatement = establishConnection().prepareStatement(deleteCategorySQL);
    //         preparedStatement.setInt(1, idCategory);

    //         preparedStatement.execute();
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     }
    // }


    /**
     * Forbinder til vores cloud baseret database.
     * */
    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
