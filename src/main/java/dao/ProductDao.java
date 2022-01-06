package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final static Connection connection = ConnectMySql.getConnection();
    private static PreparedStatement preparedStatement;
    public List<Product> getAllProduct() {
        String sqlGetAll = "SELECT product.id,product.name,product.price,product.quantity,product.color,product.description,category.category  FROM product join category on product.idcategory = category.idcategory ";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");


                products.add(new Product(id, name, price,quantity, color, description,category));
            }
            return products;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product findByID(int id) {
        String getAllSql  = "Select * from product where id = ?";
        Product product = new Product();
        try {
            preparedStatement = connection.prepareStatement(getAllSql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_sp = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int idcategory = rs.getInt("idcategory");
                product = new Product(id_sp, name ,price , quantity, color, description, idcategory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public Product findByName(String nameFind) {
        String find = "SELECT product.*, category.category FROM DemoJDBC2.product join category on product.idcategory = classroom.idcategory\n" +
                "where product.name like '%"+nameFind+"%\'";
        Product product = new Product();
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(find);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                String color = resultSet.getString("color");
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                int idClassRoom = resultSet.getInt("idcategory");
                product= new Product(id, name, price, quantity, color, description, category, idClassRoom);
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveProduct(Product product) {
        String saveSQl = "INSERT INTO product(name,price,quantity,color,description,idCategory) VALUES (?,?,?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQl);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategoryID());
            preparedStatement.execute();
            connection.commit();

        }catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int id){
        String deleteSQL = "DELETE from product where id = ?";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateProduct(Product product) {
        String sqlUpdate = "update product set name = ?, price = ? , quantity = ? , color = ?,description = ?, idCategory = ?  where id=? ";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryID());
            preparedStatement.setInt(7, product.getIdProduct());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
