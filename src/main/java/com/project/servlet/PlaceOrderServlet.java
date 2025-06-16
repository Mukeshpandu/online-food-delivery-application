package com.project.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get order details from the form
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String mobile = req.getParameter("mobile");

        // You can store this data in DB (optional), and clear cart
        HttpSession session = req.getSession();
        session.removeAttribute("cart");
        session.removeAttribute("restaurantId");

        // Set attributes for confirmation page
        req.setAttribute("name", name);
        req.setAttribute("address", address);
        req.setAttribute("mobile", mobile);

        // Forward to a confirmation page
        req.getRequestDispatcher("ordersuccess.jsp").forward(req, res);
    }
}
