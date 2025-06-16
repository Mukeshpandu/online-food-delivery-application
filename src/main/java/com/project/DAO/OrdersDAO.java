package com.project.DAO;

import com.project.model.Orders;
import java.util.*;
public interface OrdersDAO {
	
	List<Orders> getAllOrders();
	Orders getOrderById(int orderId);
	void addOrders(Orders order);
	void updateOrders(Orders order);
	void deleteOrders(int orderId);
	

}
