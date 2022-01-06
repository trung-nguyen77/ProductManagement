package service;

import dao.CategoryDao;
import model.Category;

import java.util.List;

public class CategoryService {
    private static final CategoryDao categoryDao = new CategoryDao();
    public List<Category> findAll(){
        return CategoryDao.getAllCategory();
    }
}
