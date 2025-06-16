package com.project.DAO;
import com.project.model.OrderItems;
import java.util.*;
public interface OrderItemDAO {
	
	List<OrderItems> getAllOrderItems();
	OrderItems getOrderItemById(int orderItemId);
	void addOrderItems(OrderItems orderItems);
	void updateOrderItems(OrderItems orderItems);
	void deleteOrderItems(int orderItemId);
	

}
