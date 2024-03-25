package com.hexaware.model;

public class Clothing extends Product{
	
	private String size;
	private String color;
	
	public Clothing() {
	
	}
	
	public Clothing(int productId, String productName, String description, double price, int quantityStock,
			ProductType type) {
		super(productId, productName, description, price, quantityStock, type);
		
	}
	
	public Clothing(String productName, String description, double price, int quantityStock, ProductType type) {
		super(productName, description, price, quantityStock, type);
		
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + ", getSize()=" + getSize() + ", getColor()=" + getColor()
				+ ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName()
				+ ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getQuantityStock()="
				+ getQuantityStock() + ", getType()=" + getType() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
