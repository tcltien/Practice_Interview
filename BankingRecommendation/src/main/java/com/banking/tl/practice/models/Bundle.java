package com.banking.tl.practice.models;

import java.util.List;

public class Bundle {

	int id;
	String bundleName;
	List<Product> listProduct;
	int value;
	int age;
	int income;
	boolean isStudent;

	public Bundle(int id, String bundleName, List<Product> listProduct, int value, int age, int income,
			boolean isStudent) {
		super();
		this.id = id;
		this.bundleName = bundleName;
		this.listProduct = listProduct;
		this.value = value;
		this.age = age;
		this.income = income;
		this.isStudent = isStudent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public List<Product> listProduct() {
		return listProduct;
	}

	public void setListRule(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	@Override
	public String toString() {
		return "Bundle [id=" + id + ", bundleName=" + bundleName + ", listProduct=" + listProduct + "]";
	}

}