package com.neu.entity;

import java.util.List;

public class ShoppingCart {
	private User user;
	private List<ShoppingItem> shoppingItems;
	private Double total;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ShoppingItem> getShoppingItems() {
		return shoppingItems;
	}
	public void setShoppingItems(List<ShoppingItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(User user, List<ShoppingItem> shoppingItems, Double total) {
		super();
		this.user = user;
		this.shoppingItems = shoppingItems;
		this.total = total;
	}

}
