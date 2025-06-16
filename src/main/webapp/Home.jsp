<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.project.model.Restaurant, java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Restaurants</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- <div id="popup" class="popup-message"></div> -->

<div id="notification-bar" class="notification-bar"></div>

<nav class="navbar">
  <div class="navbar-left">
    <img src="images/swiggylogo.png" alt="Logo" class="logo">
    <div class="location">
      <span class="city">Proddatur</span>
      <span class="dropdown">▼</span>
    </div>
  </div>
  <div class="navbar-right">
    <a href="#">Search</a>
    <a href="#">Offers</a>
    <a href="#">Help</a>
    <a href="#">Cart</a>
    <a href="#" onclick="toggleModals('login')">Login</a>
  </div>
</nav>

<h1 class="title">Available Restaurants</h1>

<div class="restaurant-container">
<%
    List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
    for(Restaurant restaurant: restaurants){
%>
  <div class="restaurant-card">
    <a href="menu?restaurantId=<%= restaurant.getResturantId() %>" style="text-decoration: none; color: inherit;">
      <img src="<%= restaurant.getImagePath() %>" alt="Not Available" />
      <div class="restaurant-info">
        <h2><%= restaurant.getName() %></h2>
        <p>⭐ <%= restaurant.getRating() %> · <%= restaurant.getDeliveryTime() %></p>
        <p class="desc"><%= restaurant.getCuisineType() %></p>
      </div>
    </a>
  </div>
<% } %>
</div>

<footer class="footer">
  <div class="footer-section">
    <h3>Company</h3>
    <ul>
      <li><a href="#">About us</a></li>
      <li><a href="#">Team</a></li>
      <li><a href="#">Careers</a></li>
      <li><a href="#">Blog</a></li>
    </ul>
  </div>
  <div class="footer-section">
    <h3>Contact</h3>
    <ul>
      <li><a href="#">Help & Support</a></li>
      <li><a href="#">Partner with us</a></li>
      <li><a href="#">Ride with us</a></li>
    </ul>
  </div>
  <div class="footer-section">
    <h3>Legal</h3>
    <ul>
      <li><a href="#">Terms & Conditions</a></li>
      <li><a href="#">Refund & Cancellation</a></li>
      <li><a href="#">Privacy Policy</a></li>
      <li><a href="#">Cookie Policy</a></li>
    </ul>
  </div>
  <div class="footer-section">
    <h3>Social Links</h3>
    <ul>
      <li><a href="#">Facebook</a></li>
      <li><a href="#">Twitter</a></li>
      <li><a href="#">Instagram</a></li>
      <li><a href="#">YouTube</a></li>
    </ul>
  </div>
</footer>

<!-- Register Modal -->
<div id="registerModal" class="modal" style="display:none;">
  <form action="callinguser" method="post" class="modal-content">
    <h2>Register</h2>
    <input type="text" name="name" placeholder="Full Name" required>
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="email" name="email" placeholder="Email" required>
    <input type="text" name="phonenumber" placeholder="Phone Number" required>
    <textarea name="address" placeholder="Address"></textarea>
    <select name="role" required>
      <option value="Customer">Customer</option>
      <option value="RestaurantOwner">Restaurant Owner</option>
      <option value="Admin">Admin</option>
    </select>
    <button type="submit">Register</button>
    <p>Already have an account? <a href="#" onclick="toggleModals('login')">Login</a></p>
  </form>
</div>

<!-- Login Modal -->
<div id="loginModal" class="modal" style="display:none;">
  <form action="login" method="post" class="modal-content">
    <h2>Login</h2>
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <button type="submit">Login</button>
    <p>Don't have an account? <a href="#" onclick="toggleModals('register')">Register</a></p>
  </form>
</div>

<script>

function toggleModals(mode) {
	  document.getElementById("registerModal").style.display = mode === 'register' ? 'flex' : 'none';
	  document.getElementById("loginModal").style.display = mode === 'login' ? 'flex' : 'none';
	}

  window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const message = urlParams.get("message");
    const notification = document.getElementById("notification-bar");

    if (message) {
      let text = "";
      let color = "#323232";

      if (message === "registered") {
        text = "✅ Registration Successful!";
        color = "#28a745";
      } else if (message === "register_failed") {
        text = "❌ Registration Failed!";
        color = "#dc3545";
      } else if (message === "login_success") {
        text = "✅ Login Successful!";
        color = "#28a745";
      } else if (message === "invalid") {
        text = "❌ Invalid Username or Password!";
        color = "#ffc107";
      } else if (message === "error") {
        text = "❌ Something went wrong!";
        color = "#dc3545";
      }

      notification.innerText = text;
      notification.style.backgroundColor = color;
      notification.style.display = "block";

      setTimeout(() => {
        notification.style.display = "none";
      }, 3000);
    }
  }
</script>


</body>
</html>
