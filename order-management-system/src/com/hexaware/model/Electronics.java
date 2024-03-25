package com.hexaware.model;

public class Electronics extends Product{

	private String brand;
	private int warrantyPeriod;
	
	public Electronics() {
		
	}
	public Electronics(int productId, String productName, String description, double price, int quantityStock,
			ProductType type) {
		super(productId, productName, description, price, quantityStock, type);
		
	}
	public Electronics(String productName, String description, double price, int quantityStock, ProductType type) {
		super(productName, description, price, quantityStock, type);
		
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	@Override
	public String toString() {
		return "Electronics [brand=" + brand + ", warrantyPeriod=" + warrantyPeriod + ", getBrand()=" + getBrand()
				+ ", getWarrantyPeriod()=" + getWarrantyPeriod() + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getDescription()=" + getDescription() + ", getPrice()="
				+ getPrice() + ", getQuantityStock()=" + getQuantityStock() + ", getType()=" + getType()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
