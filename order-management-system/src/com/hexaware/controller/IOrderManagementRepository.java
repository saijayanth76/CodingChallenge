package com.hexaware.controller;

import java.util.List;

import com.hexaware.model.Orders;
import com.hexaware.model.Product;
import com.hexaware.model.User;

public interface IOrderManagementRepository {

	public void CreateUser(User user);
	
	public void createOrder(List<Product> productList, String username, int productId, int quantity);
	
	public void cancelOrder(int orderId);
	
	public List<Orders> getOrderByUser(String username);
	
	public void createProduct();
	
	public List<Product> getAllProducts();
	
}
