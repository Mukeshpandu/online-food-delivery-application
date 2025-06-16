package com.project.model;

public class Restaurant {
	
	private int resturantId;
	private String name;
	private String address;
	private String phoneNumber;
	private String cuisineType;
	private int deliveryTime;
	private int adminuserId;
	private double rating;
	private boolean isActive;
	private String imagePath;
	
	public Restaurant() {
	}

	public Restaurant(int resturantId, String name, String address, String phoneNumber, String cuisineType,
			int deliveryTime, int adminuserId, double rating, boolean isActive, String imagePath) {
		super();
		this.resturantId = resturantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminuserId = adminuserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	
	

	public Restaurant(String name, String address, String phoneNumber, String cuisineType, int deliveryTime,
			String imagePath, double rating) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.imagePath = imagePath;
		this.rating = rating;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getAdminuserId() {
		return adminuserId;
	}

	public void setAdminuserId(int adminuserId) {
		this.adminuserId = adminuserId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}	
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [resturantId=" + resturantId + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", cuisineType=" + cuisineType + ", deliveryTime=" + deliveryTime + ", adminuserId="
				+ adminuserId + ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}
}
