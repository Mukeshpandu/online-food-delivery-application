package com.project.model;

public class Menu {
	
	private int menuId;
	private int resturantId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvailable;
	private double rating;
	private String imagePath;
	
	public Menu() {

	}

	public Menu(int menuId, int resturantId, String itemName, String description, double price, boolean isAvailable,
			double rating, String imagePath) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.imagePath = imagePath;
	}
	
	

	public Menu(String itemName, String description, double price, boolean isAvailable, double rating,
			String imagePath) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", resturantId=" + resturantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", rating=" + rating
				+ ", imagePath=" + imagePath + "]";
	}
	
	

}
