package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
	    String email = req.getParameter("email");
	    String mobile = req.getParameter("mobile");
	    String password = req.getParameter("password");
	    
	    
	    try (Connection con = DBConnection.getConnection()) {
	        PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email, phonenumber, password) VALUES (?, ?, ?, ?)");
	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setString(3, mobile);
	        ps.setString(4, password); 
	        int i = ps.executeUpdate();

	        if (i > 0) {
	          resp.sendRedirect("first?message=registered");
	        } else {
	          resp.sendRedirect("first?message=register_failed");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	        resp.sendRedirect("first?message=error");
	      }
	    
	    
	    
	}
	
	


}
