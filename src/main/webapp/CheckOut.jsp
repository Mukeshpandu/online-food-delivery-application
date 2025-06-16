<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.project.cart.Cart" %>

<%
  Cart cart = (Cart) session.getAttribute("cart");
  if (cart == null || cart.getAllItems().isEmpty()) {
%>
  <html>
  <head>
    <style>
      body {
        font-family: 'Segoe UI', sans-serif;
        background-color: #f8fafc;
        color: #555;
        text-align: center;
        padding: 50px;
      }
    </style>
  </head>
  <body>
    <h2>🛒 Your cart is empty!</h2>
    <a href="menu?restaurantId=1" style="text-decoration: none;">
      <button style="padding: 10px 20px; background-color: #3b82f6; color: white; border: none; border-radius: 8px; cursor: pointer;">Add Items</button>
    </a>
  </body>
  </html>
<%
  } else {
%>

<html>
<head>
  <title>Checkout</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f1f5f9;
      margin: 0;
      padding: 40px 0;
    }

    .container {
      width: 50%;
      margin: auto;
      background-color: #ffffff;
      padding: 30px 40px;
      border-radius: 15px;
      box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.05);
      animation: slide-up 0.5s ease-in-out;
    }

    @keyframes slide-up {
      from {
        opacity: 0;
        transform: translateY(30px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    h2 {
      text-align: center;
      color: #10b981;
      margin-bottom: 30px;
    }

    label {
      font-weight: bold;
      display: block;
      margin-bottom: 5px;
      margin-top: 15px;
      color: #333;
    }

    input[type="text"],
    textarea {
      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 8px;
      resize: none;
      font-size: 16px;
    }

    .btn {
      margin-top: 30px;
      width: 100%;
      padding: 12px;
      font-size: 18px;
      background-color: #3b82f6;
      color: white;
      border: none;
      border-radius: 10px;
      cursor: pointer;
      transition: background 0.3s;
    }

    .btn:hover {
      background-color: #2563eb;
    }

    .note {
      font-size: 14px;
      color: #888;
      margin-top: 10px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>🚚 Enter Your Delivery Details</h2>
    <form action="placeOrder" method="post">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" required>

      <label for="address">Delivery Address</label>
      <textarea name="address" id="address" rows="4" required></textarea>

      <label for="mobile">Mobile Number</label>
      <input type="text" name="mobile" id="mobile" pattern="[0-9]{10}" maxlength="10" required>

      <button type="submit" class="btn">✅ Place Order</button>
      <p class="note">We'll deliver hot and fresh food at your doorstep 🏠</p>
    </form>
  </div>
</body>
</html>

<% } %>
