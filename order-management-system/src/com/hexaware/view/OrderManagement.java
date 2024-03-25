package com.hexaware.view;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hexaware.controller.AuthenticateService;
import com.hexaware.controller.IAuthenticateService;
import com.hexaware.controller.IOrderManagementRepository;
import com.hexaware.controller.OrderProcessor;
import com.hexaware.model.Orders;
import com.hexaware.model.Product;
import com.hexaware.model.User;

public class OrderManagement {

	public static void main(String[] args) {

		IAuthenticateService authService = new AuthenticateService();
		IOrderManagementRepository orderProcessor = new OrderProcessor();

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Order Management System ");
		System.out.println();
		System.out.println("1. Login as User ");
		System.out.println("2. Login as Admin ");
		System.out.println("3. Register as a new User ");
		System.out.println();

		int loginType = in.nextInt();
		if (loginType == 1) {

			System.out.println("Enter the username :");
			String username = in.next();
			System.out.println("Enter the password :");
			String password = in.next();
			boolean exists = false;

			exists = authService.isUserExists(username, password);
			if (exists) {

				String ch = null;

				do {
					System.out.println("Enter your choice:");
					System.out.println("1. Create a new Order");
					System.out.println("2. Cancel Order");
					System.out.println("3. View all Orders made by " + username);

					int choice = in.nextInt();
					switch (choice) {

					case 1: {
						List<Product> productList = orderProcessor.getAllProducts();
						Iterator<Product> it = productList.iterator();

						while (it.hasNext()) {

							System.out.println(it.next());
						}

						System.out.println("Enter the productId from above List: ");
						int productId = in.nextInt();

						System.out.println("Enter the Quantity: ");
						int quantity = in.nextInt();

						orderProcessor.createOrder(productList, username, productId, quantity);

						break;
					}
					case 2: {
						List<Orders> ordersList = orderProcessor.getOrderByUser(username);

						Iterator<Orders> it = ordersList.iterator();

						while (it.hasNext()) {

							System.out.println(it.next());
						}

						System.out.println("Enter the order id to do cancellation from above list");
						int orderId = in.nextInt();

						orderProcessor.cancelOrder(orderId);
						break;
					}
					case 3: {

						System.out.println("All Orders made by " + username);

						List<Orders> ordersList = orderProcessor.getOrderByUser(username);

						Iterator<Orders> it = ordersList.iterator();

						while (it.hasNext()) {

							System.out.println(it.next());
						}
						break;
					}
					default: {
						System.out.println("Enter the right choice. ");
					}

					}
					System.out.println("Do you want to continue? Press(Y/y)");
					ch = in.next();
				} while (ch.equals("Y") || ch.equals("y"));
				System.out.println("Thanks for using our system !!! Exiting...");
				System.exit(0);

			}

		}

		else if (loginType == 2) {

			System.out.println("Enter the username :");
			String username = in.next();
			System.out.println("Enter the password :");
			String password = in.next();
			boolean exists = false;

			exists = authService.isAdminExists(username, password);
			if (exists) {

				String ch = null;

				do {
					System.out.println("Enter your choice: ");
					System.out.println("1. Create a new User ");
					System.out.println("2. View all Product Details ");
					System.out.println("3. Create Product ");
			
					int choice = in.nextInt();
					switch (choice) {
						
					case 1:{
						User user = new User();
						orderProcessor.CreateUser(user);
						break;
						
					}
					case 2:{
						List<Product> productList = orderProcessor.getAllProducts();
						Iterator<Product> it = productList.iterator();

						while (it.hasNext()) {

							System.out.println(it.next());
						}
						break;
					}
					case 3:{
						
						orderProcessor.createProduct();
					}
					}
					
					System.out.println("Do you want to continue? Press(Y/y)");
					ch = in.next();
				} while (ch.equals("Y") || ch.equals("y"));
				System.out.println("Thanks for using our system !!! Exiting...");
				System.exit(0);
			}
		}

	}

}
