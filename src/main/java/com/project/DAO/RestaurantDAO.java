package com.project.DAO;

import com.project.model.Restaurant;

import java.util.*;

public interface RestaurantDAO {
	
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurantId);
	void addRestaurants(Restaurant restaurant);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	

}
