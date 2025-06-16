package com.project.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import com.project.DAOImpl.RestaurantDAOImpl;
import com.project.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class HomeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			RestaurantDAOImpl daoImpl = new RestaurantDAOImpl();
			List<Restaurant> allRestaurants =  daoImpl.getAllRestaurants();
			for(Restaurant restaurant : allRestaurants) {
				System.out.println(restaurant);
			}
			req.setAttribute("allRestaurants", allRestaurants);
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
