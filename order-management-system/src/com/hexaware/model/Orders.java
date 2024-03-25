package com.hexaware.model;

import java.time.LocalDate;

public class Orders {

	private int orderId;
	private int userId;
	private int productId;
	private int quantity;
	private double totalCost;
	private LocalDate orderDate;
	private Product product;
	private User user;

	public Orders() {

	}

	public Orders(int orderId, int userId, int productId, int quantity, double totalCost, LocalDate orderDate) {

		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}

	public Orders(int userId, int productId, int quantity, double totalCost, LocalDate orderDate) {

		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", totalCost=" + totalCost + ", orderDate=" + orderDate + "]";
	}

}
