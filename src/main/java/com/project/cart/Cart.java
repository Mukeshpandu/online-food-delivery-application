package com.project.cart;

import com.project.model.CartItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }
    public void addItem(CartItem item) {
        if (items.containsKey(item.getMenuId())) {
            CartItem existingItem = items.get(item.getMenuId());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getMenuId(), item);
        }
    }
    public void updateItem(int menuId, int newQuantity) {
        if (items.containsKey(menuId)) {
            CartItem item = items.get(menuId);
            item.setQuantity(newQuantity);
        }
    }
    public void deleteItem(int menuId) {
        items.remove(menuId);
    }

    public Collection<CartItem> getAllItems() {
        return items.values();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }
    public int getTotalItems() {
        return items.size();
    }
}
