package service;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final ProductDao productDao = new ProductDao();

    public List<Product> findAll(){
        return productDao.getAllProduct();
    }

    public void save(Product product){
        ProductDao.saveProduct(product);
    }

    public Product findById(int id){
        return productDao.findByID(id);
    }

    public void delete(int id){
        productDao.deleteProduct(id);
    }

    public void edit(Product product){
        productDao.updateProduct(product);
    }

    public Product findByName(String find){
        return productDao.findByName(find);
    }
}
