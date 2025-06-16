package com.project.servlet;

import java.io.IOException;

import com.project.cart.Cart;
import com.project.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Integer oldRestaurantIdObj = (Integer) session.getAttribute("restaurantId");
        int oldRestaurantId = (oldRestaurantIdObj != null) ? oldRestaurantIdObj : -1;
        int newRestaurantId = Integer.parseInt(req.getParameter("restaurantId"));

        if (cart == null || oldRestaurantId != newRestaurantId) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("restaurantId", newRestaurantId);
        }

        String action = req.getParameter("action");
        try {
            if ("add".equals(action)) {
                addItemToCart(req, cart);
            } else if ("update".equals(action)) {
                updateCart(req, cart);
            } else if ("delete".equals(action)) {
                deleteCart(req, cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("cart.jsp");
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
            String itemName = req.getParameter("itemname");
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String imagePath = req.getParameter("imagePath");

            CartItem item = new CartItem(menuId, restaurantId, itemName, quantity, price, imagePath);
            cart.addItem(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            if(quantity <= 0) {
            	cart.deleteItem(menuId);
            }else {
            	cart.updateItem(menuId, quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            cart.deleteItem(menuId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
