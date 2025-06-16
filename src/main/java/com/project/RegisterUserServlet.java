package com.project;

import java.io.IOException;


import java.io.PrintWriter;

import com.project.DAOImpl.UserDAOImpl;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callinguser")
public class RegisterUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		User u = new User(name, username, password, email, phonenumber, address, role);
		UserDAOImpl udao = new UserDAOImpl();
		boolean success = udao.addUser(u);
		

	    if (success) {
	    	res.sendRedirect("first?message=registered");
	    } else {
	    	res.sendRedirect("first?message=register_failed");
	    }
	}
}
