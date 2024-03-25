package com.hexaware.model;

public class Product {

	private int productId;
	private String productName;
	private String description;
	private double price;
	private int quantityStock;
	private ProductType type;
	
	public Product() {
		
	}

	public Product(int productId, String productName, String description, double price, int quantityStock,
			ProductType type) {
		
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantityStock = quantityStock;
		this.type = type;
	}
	
	public Product(String productName, String description, double price, int quantityStock,
			ProductType type) {
	
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantityStock = quantityStock;
		this.type = type;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", quantityStock=" + quantityStock + ", type=" + type + "]";
	}

	
}
