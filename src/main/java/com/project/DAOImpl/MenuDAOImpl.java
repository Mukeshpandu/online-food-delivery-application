package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.DAO.MenuDAO;
import com.project.model.Menu;
import com.project.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {

	private String GET_ALL_MENU_ITEMS = "select * from Menu WHERE restaurantid = ?";
	private String GET_MENU_BYID = "select * from `Menu` where `menuid` = ? ";
	private String ADD_MENU_ITEM = "insert into Menu (`restaurantid`, `itemname`, `description`, `price`, `isAvailable`, `rating`, `imagepath`) values (?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE_MENU = "update Menu set `restaurantid` = ?, `itemname` = ?, `description` = ?, `price` = ?, `isAvailable` = ?, `rating` = ?, `imagepath` = ? where `menuid` = ?";
	private String DELETE_MENU_ITEM = "delete from `Menu` where `menuid` = ?";

	@Override
	public List<Menu> getAllMenuItems(int restaurantid) {
	    List<Menu> AllMenuItems = new ArrayList<>();
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MENU_ITEMS)) {

	        preparedStatement.setInt(1, restaurantid);
	        ResultSet res = preparedStatement.executeQuery();

	        while (res.next()) {
	            int id = res.getInt("menuid");
	            int rid = res.getInt("restaurantid");
	            String name = res.getString("itemname");
	            String desc = res.getString("description"); 
	            double price = res.getDouble("price");
	            boolean isavaliable = res.getBoolean("isAvailable");
	            double rating = res.getDouble("rating");
	            String imagepath = res.getString("imagepath");

	            // ✅ Use constructor that sets menuId
	            Menu menu = new Menu(id, rid, name, desc, price, isavaliable, rating, imagepath);
	            AllMenuItems.add(menu);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return AllMenuItems;
	}

	@Override
	public Menu getMenuById(int menuId) {
		Menu menu = null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_MENU_BYID)) {
			preparedStatement.setInt(1, menuId);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()) {
				int id = res.getInt("menuid");
				int rid = res.getInt("restaurantid");
				String name = res.getString("itemname");
				String desc = res.getString("itemname");
				double price = res.getDouble("price");
				boolean isavaliable = res.getBoolean("isAvailable");
				double rating = res.getDouble("rating");
				String imagepath = res.getString("imagepath");
				menu = new Menu(id, rid, name, desc, price, isavaliable, rating, imagepath);
			}
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	@Override
	public void addMenuItem(Menu menu) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(ADD_MENU_ITEM)) {
			preparedStatement.setInt(1, menu.getResturantId());
			preparedStatement.setString(2, menu.getItemName());
			preparedStatement.setString(3, menu.getDescription());
			preparedStatement.setDouble(4, menu.getPrice());
			preparedStatement.setBoolean(5, menu.isAvailable());
			preparedStatement.setDouble(6, menu.getRating());
			preparedStatement.setString(7, menu.getImagePath());
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateMenuItem(Menu menu) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MENU)) {
			preparedStatement.setInt(1, menu.getResturantId());
			preparedStatement.setString(2, menu.getItemName());
			preparedStatement.setString(3, menu.getDescription());
			preparedStatement.setDouble(4, menu.getPrice());
			preparedStatement.setBoolean(5, menu.isAvailable());
			preparedStatement.setDouble(6, menu.getRating());
			preparedStatement.setString(7, menu.getImagePath());
			preparedStatement.setInt(8, menu.getMenuId());
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMenuItem(int menuId) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MENU_ITEM )) {
			preparedStatement.setInt(1, menuId);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
