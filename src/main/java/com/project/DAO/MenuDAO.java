package com.project.DAO;

import com.project.model.Menu;
import java.util.*;

public interface MenuDAO {
	
	List<Menu> getAllMenuItems(int menuId);
	Menu getMenuById(int menuId);
	void addMenuItem(Menu menu);
	void updateMenuItem(Menu menu);
	void deleteMenuItem(int menuId);

}
