package dao;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private static Connection connection = ConnectMySql.getConnection();

    public static List<Category> getAllCategory() {
        String sqlGetAll = "SELECT * FROM category";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Category> categories = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("idcategory");
                String name = resultSet.getString("category");

                categories.add(new Category(id, name));
            }
            return categories;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
