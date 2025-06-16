<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.project.model.CartItem, com.project.cart.Cart, java.util.List, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Your Cart</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
      background-color: #f9fafb;
    }

    table {
      width: 80%;
      margin: 0 auto;
      border-collapse: collapse;
      background-color: white;
    }

    th, td {
      padding: 12px;
      border-bottom: 1px solid #ccc;
      text-align: center;
    }

    img {
      width: 80px;
      height: 80px;
      object-fit: cover;
    }

    .btn {
      padding: 6px 12px;
      background-color: #38bdf8;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #0ea5e9;
    }

    .top-buttons {
      text-align: right;
      margin: 20px 10%;
    }
  </style>
</head>
<body>

  <h2 style="text-align:center;">🛒 Your Cart</h2>

  <%
    Cart cart = (Cart) session.getAttribute("cart");
  	Integer restaurantId = (Integer) session.getAttribute("restaurantId");
    List<CartItem> cartItems = null;

    if (cart != null) {
        cartItems = new ArrayList<>(cart.getAllItems());
    }

    if (cartItems == null || cartItems.isEmpty()) {
  %>
    <h3 style="text-align:center;">Your cart is empty!</h3>
    <div class="top-buttons">
    	<a href="menu?restaurantId=<%= session.getAttribute("restaurantId")%>"><button class="btn">Add Items</button></a>
  	</div>
    
  <% } else { %>

  <div class="top-buttons">
    <a href="menu?restaurantId=<%= session.getAttribute("restaurantId")%>"><button class="btn">Add More Items</button></a>
  </div>

  <table>
    <thead>
      <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <%
        double totalAmount = 0;
        for (CartItem item : cartItems) {
          double itemTotal = item.getQuantity() * item.getPrice();
          totalAmount += itemTotal;
      %>
      <tr>
        <td><img src="<%= item.getImagePath() %>"></td> 
        <td><%= item.getItemName() %></td>
        <td>
		  <form action="cart" method="post" style="display:inline;">
		    <input type="hidden" name="action" value="update">
		    <input type="hidden" name="menuid" value="<%= item.getMenuId() %>">
		      <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
		      <input type="hidden" name="quantity" value="<%= item.getQuantity() > 1 ? item.getQuantity() - 1 : 0 %>">
		    <button type="submit" class="btn">-</button>
		  </form>
		
		  <span style="margin: 0 10px;"><%= item.getQuantity() %></span>
		
		  <form action="cart" method="post" style="display:inline;">
		    <input type="hidden" name="action" value="update">
		    <input type="hidden" name="menuid" value="<%= item.getMenuId() %>">
		      <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
		    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
		    <button type="submit" class="btn">+</button>
		  </form>
		</td>

        <td>₹<%= item.getPrice() %></td>
        <td>₹<%= itemTotal %></td>
      </tr>
      <% } %>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="4" style="text-align:right;"><strong>Grand Total:</strong></td>
        <td colspan="2"><strong>₹<%= totalAmount %></strong></td>
      </tr>
    </tfoot>
  </table>
  
  <div style="width: 80%; margin: 20px auto; text-align: right;">
  <form action="CheckOut.jsp" method="get">
    <button type="submit" class="btn" style="font-size: 16px; padding: 10px 20px;">
      Proceed to Checkout →
    </button>
  </form>
</div>
  
  <% } %>

</body>
</html>
