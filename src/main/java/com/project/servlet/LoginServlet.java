package com.project.servlet;

import java.io.IOException;



import com.project.DAOImpl.UserDAOImpl;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");

	    UserDAOImpl dao = new UserDAOImpl();
	    User user = dao.getUserByUsernameAndPassword(username, password); 

	    if (user != null) {
	      req.getSession().setAttribute("user", user);
	      res.sendRedirect("first?message=login_success"); 
	    } else {
	      res.sendRedirect("first?message=invalid");
	    }
	  }
	}



