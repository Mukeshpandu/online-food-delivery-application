package com.project.DAOImpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.project.DAO.UserDAO;
import com.project.model.User;
import com.project.util.DBConnection;

public class UserDAOImpl implements UserDAO {
	private final String INSERT = "insert into `users` (`name`, `username`, `password`, `email`, `phonenumber`, `address`, `role`, `created_date`, `last_login_date`) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "Update `users` set `name` = ?, `username` = ?, `password` = ?, `email` = ?, `phonenumber` = ?, `address` = ?, `role`= ?";
	private String GET_USER_BYID = "select * from `users` where `userid` = ?";
	private String GET_ALL_USERS = "select * from `users`";
	private String DELETE_USER = "delete from `users` where userid = ?";

	@Override
	public List<User> getAllUsers() {
		
		List<User> allUsers = new ArrayList<User>();
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(GET_ALL_USERS );) {
			
			
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("userid");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phonenumber = resultSet.getString("phonenumber");
				String address = resultSet.getString("address");
				String role = resultSet.getString("role");
				Timestamp created_date = resultSet.getTimestamp("created_date");
				Timestamp lastlogindate = resultSet.getTimestamp("last_login_date");
				User u = new User(id, name, username, password, email, phonenumber, address, role, created_date, lastlogindate);
				allUsers.add(u);
			}
			int i = preparedstatement.executeUpdate();
			System.out.println(i);
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
		
	}

	@Override
	public User getUserById(int userId) {
		User u = null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(GET_USER_BYID );) {
			preparedstatement.setInt(1, userId);
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("userId");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phonenumber = resultSet.getString("phonenumber");
				String address = resultSet.getString("address");
				String role = resultSet.getString("role");
				Timestamp created_date = resultSet.getTimestamp("created_date");
				Timestamp lastlogindate = resultSet.getTimestamp("last_login_date");
				u = new User(id, name, username, password, email, phonenumber, address, role, created_date, lastlogindate);
			}
			int i = preparedstatement.executeUpdate();
			System.out.println(i);
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean addUser(User u) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT);) {
			preparedstatement.setString(1, u.getName());
			preparedstatement.setString(2, u.getUsername());
			preparedstatement.setString(3, u.getPassword());
			preparedstatement.setString(4, u.getEmail());
			preparedstatement.setString(5, u.getPhonenumber());
			preparedstatement.setString(6, u.getAddress());
			preparedstatement.setString(7, u.getRole());
			preparedstatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			preparedstatement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			int i = preparedstatement.executeUpdate();
//			System.out.println(i);
//			System.out.println("Connection: " + connection);
			return true;
		}  catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void updateUser(User u) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(UPDATE)){
			preparedstatement.setString(1, u.getName());
			preparedstatement.setString(2, u.getUsername());
			preparedstatement.setString(3, u.getPassword());
			preparedstatement.setString(4, u.getEmail());
			preparedstatement.setString(5, u.getPhonenumber());
			preparedstatement.setString(6, u.getAddress());
			preparedstatement.setString(7, u.getRole());
			int i = preparedstatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userid) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
			
			preparedStatement.setInt(1, userid);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public User getUserByUsernameAndPassword(String username, String password) {
		  User user = null;
		  try (Connection con = DBConnection.getConnection()) {
		    PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
		    ps.setString(1, username);
		    ps.setString(2, password);
		    ResultSet rs = ps.executeQuery();

		    if (rs.next()) {
		      user = new User();
		      user.setUsername(username);
		      user.setPassword(password);
		      // set other fields if needed
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return user;
		}


}
