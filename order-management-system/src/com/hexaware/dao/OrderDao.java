package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.hexaware.model.Orders;
import com.hexaware.util.DBUtil;


public class OrderDao {
	
	public void createOrder(Orders order) throws SQLException {

	Connection conn = DBUtil.getDBConn();

	String query = "INSERT INTO Orders (userId, productId, quantity, totalCost,orderDate)"
			+ "VALUES (?, ?, ?, ?, ?)";

	PreparedStatement stmt = conn.prepareStatement(query);

	stmt.setInt(1, order.getUserId());
	stmt.setInt(2, order.getProductId());
	stmt.setInt(3, order.getQuantity());
	stmt.setDouble(4, order.getTotalCost());
	stmt.setDate(5, Date.valueOf(order.getOrderDate()));
	

	stmt.executeUpdate();
	DBUtil.dbClose();
	System.out.println("Order Created Successfully!!");
	
	}
	
	public boolean cancelOrder(int orderId) throws SQLException {
		
		boolean isDeleted = false;
		
		Connection conn = DBUtil.getDBConn();

		String query = "delete from Orders where orderId = ?";

		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, orderId);

		if (ps.executeUpdate() == 1) {
			isDeleted = true;;
		}
		return isDeleted;
	}
	
	public List<Orders> getOrderByUser(int userId) throws SQLException{
		
		List<Orders> ordersList = null;

		Connection conn = DBUtil.getDBConn();

		String query = "select * from Orders where userId = ? ";

		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, userId);
		
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			
			int orderId = result.getInt("orderId");
			int user_id = result.getInt("userId");
			int productId = result.getInt("productId");
			int quantity = result.getInt("quantity");
			double totalCost = result.getDouble("totalCost");
			LocalDate orderDate = result.getDate("orderDate").toLocalDate();
			
			Orders order = new Orders(orderId, user_id, productId, quantity, totalCost, orderDate);
			
			ordersList.add(order);
		
		}
		return ordersList;
		
		
	}
}
