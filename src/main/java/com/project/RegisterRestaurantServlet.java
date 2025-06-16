package com.project;
import java.io.IOException;


import java.io.PrintWriter;

import com.project.DAOImpl.RestaurantDAOImpl;
import com.project.model.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegisterRestaurantServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phonenumber = req.getParameter("phonenumber");
		String cuisinetype = req.getParameter("cuisinetype");
		int deliverytime = Integer.parseInt(req.getParameter("deliverytime"));
		String imagepath = req.getParameter("imagepath");
		double rating = Double.parseDouble(req.getParameter("rating"));
		
		Restaurant restaurant = new Restaurant(name, address, phonenumber, cuisinetype, deliverytime, imagepath, rating);
		
		restaurant.setAdminuserId(1);
		restaurant.setActive(true);
		RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
		
		rdaoi.addRestaurants(restaurant);
		
		PrintWriter output = res.getWriter();
		output.println("Hi " + name + " Successfully Register as a Restaurant" );
		
	}

}
