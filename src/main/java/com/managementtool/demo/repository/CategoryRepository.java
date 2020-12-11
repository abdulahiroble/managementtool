package com.managementtool.demo.repository;

import com.managementtool.demo.models.Category;

import java.sql.*;

public class CategoryRepository {

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

    public Category selectCategoryFromDatabase(int idCategory) {

        Category categoryToReturn = new Category();

        String selectCategory = "SELECT * FROM category WHERE idcategory = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectCategory);
            preparedStatement.setInt(1, idCategory);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categoryToReturn = new Category(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categoryToReturn;
    }

    public void deleteCategoryFromDatabase(int idCategory){
        String deleteCategorySQL = "DELETE FROM category WHERE idcategory = ?";
        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(deleteCategorySQL);
            preparedStatement.setInt(1, idCategory);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://35.197.230.243/managementtool",
                "managementtool", "password");

        return connection;
    }
}
