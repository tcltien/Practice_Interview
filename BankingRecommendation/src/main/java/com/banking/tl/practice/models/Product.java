package com.banking.tl.practice.models;

public class Product {
	int id;
	String productName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Product(int id, String productName) {
		super();
		this.id = id;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + "] \n";
	}
	
}
