package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Product;
import com.hexaware.model.ProductType;
import com.hexaware.util.DBUtil;

public class ProductDao {

	public List<Product> getAllProducts() throws SQLException {

		Connection conn = DBUtil.getDBConn();

		String query = "select * from product";

		Statement stmt = conn.createStatement();

		ResultSet result = stmt.executeQuery(query);

		List<Product> productList = new ArrayList<>();

		while (result.next()) {

			int productId = result.getInt("productId");
			String productName = result.getString("productName");
			String description = result.getString("description");
			double price = result.getDouble("price");
			int quantityStock = result.getInt("quantityStock");
			ProductType type = ProductType.valueOf(result.getString("type").toUpperCase());

			Product product = new Product(productId, productName, description, price, quantityStock, type);
			
			productList.add(product);
		}
		return productList;

	}
	public void createProduct(Product product) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		
		String query = "INSERT INTO Product (productName, description, price, quantityStock, type)"
				+ "VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, product.getProductName());
		ps.setString(2, product.getDescription());
		ps.setDouble(3, product.getPrice());
		ps.setInt(4, product.getQuantityStock());
		ps.setString(5, product.getType().name());

		int rowsAffected = ps.executeUpdate();
		
		if(rowsAffected == 1) {
			System.out.println("Product Created Successfully!!");
		}

		DBUtil.dbClose();
	}
}
