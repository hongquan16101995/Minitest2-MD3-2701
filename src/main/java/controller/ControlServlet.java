package controller;

import model.Cart;
import model.Product;
import service.CartService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ControlServlet", value = "/home")
public class ControlServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final CartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                displayDetail(request, response);
                break;
            case "sortGreat":
                sortGreat(request, response);
                break;
            case "sortLess":
                sortLess(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            case "deleteCart":
                deleteCart(request, response);
                break;
            case "cart":
                displayAllOfCart(request, response);
                break;
            case "pay":
                payMoney(request, response);
                break;
            default:
                displayAllOfProduct(request, response);
        }
    }

    private void payMoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double money = cartService.payMoney();
        request.setAttribute("money", money);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cartService.deleteCartById(id);
        displayAllOfCart(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        productService.downQuantity(id);
        cartService.addProductToCart(product);
        displayAllOfProduct(request, response);
    }

    private void sortLess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService.sortLess();
        displayAllOfProduct(request, response);
    }

    private void sortGreat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService.sortGreat();
        displayAllOfProduct(request, response);
    }

    private void displayDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-detail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllOfProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllOfCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cart> carts = cartService.getCarts();
        request.setAttribute("carts", carts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request, response);
    }
}
