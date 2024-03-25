package com.hexaware.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.OrderDao;
import com.hexaware.dao.ProductDao;
import com.hexaware.dao.UserDao;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.model.Orders;
import com.hexaware.model.Product;
import com.hexaware.model.ProductType;
import com.hexaware.model.Role;
import com.hexaware.model.User;

public class OrderProcessor implements IOrderManagementRepository{
	
	ProductDao productDao = new ProductDao();
	UserDao userDao = new UserDao();
	OrderDao orderDao = new OrderDao();
	Scanner in = new Scanner(System.in);

	@Override
	public void CreateUser(User user) {
		
		System.out.println("Create username: ");
		String username = in.next();
		System.out.println("Set password");
		String password = in.next();
		System.out.println("Enter the role: ");
		Role role = Role.valueOf(in.next().toUpperCase());
		
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		
		try {
			if(userDao.createUser(user)) {
				System.out.println("User Created Successfully!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createOrder(List<Product> productList, String username, int productId, int quantity) {
		
		try {
			User user = userDao.getUserByUsername(username);
			int userId = user.getUserId();
			
			double totalCost = 0;
			for(Product product : productList) {
				
				if(product.getProductId() == productId) {
					
					totalCost = quantity * product.getPrice();
				}
			}
			
			Orders order = new Orders();
			order.setUserId(userId);
			order.setProductId(productId);
			order.setQuantity(quantity);
			order.setTotalCost(totalCost);
			order.setOrderDate(LocalDate.now());
			
			orderDao.createOrder(order);
			
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void cancelOrder(int orderId) {
		
		try {
			boolean isDeleted = orderDao.cancelOrder(orderId);
			if(isDeleted) {
				System.out.println("Order cancelled Successfully!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Orders> getOrderByUser(String username) {
		
		List<Orders> ordersList = null;
		
		try {
			User user = userDao.getUserByUsername(username);
			ordersList = orderDao.getOrderByUser(user.getUserId());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}catch (UserNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return ordersList;
	}

	@Override
	public void createProduct() {
		
		System.out.println("Enter the product Name : ");
		String productName = in.next();
		System.out.println("Enter the description: ");
		in.nextLine();
		String description = in.nextLine();
		System.out.println("Enter the price: ");
		double price = in.nextDouble();
		System.out.println("Enter the quantity stock :");
		int stock = in.nextInt();
		System.out.println("Enter the Product type: ");
		ProductType type = ProductType.valueOf(in.next());
		
		Product product1 = new Product(productName, description, price,stock, type);
		
		try {
			productDao.createProduct(product1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> productList = new ArrayList<>();
		try {
			productList = productDao.getAllProducts();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productList;
	}

}
