package com.project.DAO;

import java.util.List;

import com.project.model.User;


public interface UserDAO {
	
	
	List<User> getAllUsers();
	
	User getUserById(int userId);
	
	boolean addUser(User u);
	
	void updateUser(User u);
	
	void deleteUser(int userid);
	
	User getUserByUsernameAndPassword(String username, String password);
	
	 

}
