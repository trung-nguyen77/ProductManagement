package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private static final ProductService productService = new ProductService();
    private static final CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            default:
                showProduct(req,resp);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/createProduct.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String find = req.getParameter("find");
        Product product = productService.findByName(find);
        List<Category> list = categoryService.findAll();
        for (Category c:list) {
            if(c.getIdCategory() == product.getCategoryID())
                product.setCategory(c.getName());
        }
        req.setAttribute("product",product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/detail.jsp");
        requestDispatcher.forward(req,resp);
    }


    public void deleteProduct(HttpServletRequest request, HttpServletResponse response)  {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);

        try {
            response.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product",product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/editProduct.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> listSp = productService.findAll();
        List<Category> listC = categoryService.findAll();
        for (Product product:listSp) {
            for (Category c:listC) {
                if(product.getCategoryID()==c.getIdCategory()){
                    product.setCategory(c.getName());
                }
            }
        }
        req.setAttribute("list",listSp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                create(req,resp);
                break;
            case "edit":
                edit(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        showProduct(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String name= req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int id_category = Integer.parseInt(req.getParameter("category"));
        String description = req.getParameter("description");
        Product product = new Product(id, name, price, quantity, color, description, id_category);
        productService.edit(product);
        showProduct(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int id_category = Integer.parseInt(req.getParameter("category"));
        String description = req.getParameter("description");
        Product product = new Product(name, price, quantity, color, description, id_category);
        productService.save(product);
        showProduct(req, resp);
    }
}


