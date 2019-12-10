package com.banking.tl.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.banking.tl.practice.models.Bundle;
import com.banking.tl.practice.models.Product;

/**
 * 
 *
 */
public class App {

	public static List<Product> listProducts = new ArrayList<Product>();
	public static List<Bundle> listBundles = new ArrayList<Bundle>();

	public static void main(String[] args) {
		initializeData();
		System.out.println(listBundles.toString());
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Age: ");
		int age = sc.nextInt();
		System.out.print("Are you a student ( true or false) ? ");
		Boolean isStudent = sc.nextBoolean();
		System.out.print("Please enter income: ");
		int income = sc.nextInt();
		System.out.println("Output: " + bundleSuggestion(age, isStudent, income));
		System.out.print("Do you want to CRUD product (1: ok, 2: cancel)");
		int action = sc.nextInt();
		if (action == 1) {
			System.out.print("Option 1: create, 2: delete, 3: update");
			int option = sc.nextInt();
			System.out.println("");
			if (option == 1) {
				System.out.print("Enter product id: ");
				int productId = sc.nextInt();
				System.out.print("Enter bundle id: ");
				int bundleId = sc.nextInt();
				addProduct(productId, bundleId);
			} else if (option == 2) {
				System.out.print("Enter product id: ");
				int productId = sc.nextInt();
				System.out.print("Enter bundle id: ");
				int bundleId = sc.nextInt();
				removeProduct(productId, bundleId);
			} else if (option == 3) {
				System.out.print("Enter product name: ");
				String productName = sc.next();
				System.out.print("Enter product id: ");
				int productId = sc.nextInt();
				updateProduct(productId, productName);
			} else {
				sc.close();
				return;
			}
		}
		System.out.println(listBundles.toString());
		// close scanner
		sc.close();
	}

	/**
	 * Function get suggestion bundle for customer with your information
	 * 
	 * @param age
	 * @param isStudent
	 * @param income
	 * @return
	 */
	public static String bundleSuggestion(int age, Boolean isStudent, int income) {
		// check case student
		if (age < 18) {
			return listBundles.get(0).getValue() + "";
		} else if (isStudent) {
			if (age > 17) {
				return listBundles.get(1).getValue() + "";
			}
		} else {
			List<Bundle> lst = listBundles.stream()
					.filter(s -> age > s.getAge() && isStudent == s.isStudent() && income > s.getIncome())
					.sorted(Comparator.comparing(Bundle::getValue).reversed()).collect(Collectors.toList());
			return lst.get(0).getValue() + "";
		}
		return "Not found result";
	}

	/**
	 * Add a new product into bundle
	 * 
	 * @param productId
	 * @param bundleId
	 * @return
	 */
	public static String addProduct(int productId, int bundleId) {
		Product pro = listProducts.stream().filter(s -> s.getId() == productId).findFirst().get();
		Bundle bundle = listBundles.stream().filter(s -> s.getId() == bundleId).findFirst().get();
		List<Product> list = bundle.listProduct();
		if (pro != null && bundle != null) {
			if (pro.getId() != 7) {
				boolean isExited = list.stream().map(Product::getId).anyMatch(s -> s.equals(productId));
				if (!isExited) {
					list.add(pro);
					return "Success";
				}
				return "Product is already existed";

			} else {
				boolean isPersit = list.stream().map(Product::getId)
						.anyMatch(s -> s.equals(2) || s.equals(3) || s.equals(4));
				if (isPersit) {
					list.add(pro);
					return "Success";
				} else {
					return "Debit card can't add to this bundle";
				}
			}
		}
		return "Failed";
	}

	/**
	 * Remove a product out of bundle
	 * 
	 * @param productId
	 * @param bundleId
	 * @return
	 */
	public static boolean removeProduct(int productId, int bundleId) {
		try {
			Bundle bundle = listBundles.stream().filter(s -> s.getId() == bundleId).findFirst().get();
			if (bundle.listProduct().removeIf(s -> s.getId() == productId)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Update product name follow product Id
	 * 
	 * @param productId
	 * @param productName
	 */
	public static void updateProduct(int productId, String productName) {
		listProducts = listProducts.stream().map(s -> {
			if (s.getId() == productId) {
				s.setProductName(productName);
			}
			return s;
		}).collect(Collectors.toList());
		// update in list bundles
		for (Bundle b : listBundles) {
			List<Product> listProducts = b.listProduct();
			for (Product p : listProducts) {
				if (p.getId() == productId) {
					p.setProductName(productName);
				}
			}
		}
	}

	/**
	 * Function initial data for application
	 */
	public static void initializeData() {
		Product pro1 = new Product(1, "Junior Save Account");
		Product pro2 = new Product(2, "Current Account");
		Product pro3 = new Product(3, "Current Account Plus");
		Product pro4 = new Product(4, "Student Account");
		Product pro5 = new Product(5, "Credit Card");
		Product pro6 = new Product(6, "Gold Credit Card");
		Product pro7 = new Product(7, "Debit Card");
		listProducts.add(pro1);
		listProducts.add(pro2);
		listProducts.add(pro3);
		listProducts.add(pro4);
		listProducts.add(pro5);
		listProducts.add(pro6);
		listProducts.add(pro7);

		ArrayList<Product> juniorProduct = new ArrayList<Product>();
		juniorProduct.add(pro1);
		listBundles.add(new Bundle(1, "Junior Saver", juniorProduct, 0, 18, 0, false));

		ArrayList<Product> studentProduct = new ArrayList<Product>();
		studentProduct.add(pro4);
		studentProduct.add(pro5);
		studentProduct.add(pro7);
		listBundles.add(new Bundle(2, "Student", studentProduct, 0, 17, 0, true));

		ArrayList<Product> classicBundleProduct = new ArrayList<Product>();
		classicBundleProduct.add(pro2);
		classicBundleProduct.add(pro7);
		listBundles.add(new Bundle(3, "Classic", classicBundleProduct, 1, 17, 0, false));

		ArrayList<Product> classicPlusBundleProduct = new ArrayList<Product>();
		classicPlusBundleProduct.add(pro2);
		classicPlusBundleProduct.add(pro5);
		classicPlusBundleProduct.add(pro7);
		listBundles.add(new Bundle(4, "Classic Plus", classicPlusBundleProduct, 2, 17, 12000, false));

		ArrayList<Product> goldBundleProduct = new ArrayList<Product>();
		goldBundleProduct.add(pro3);
		goldBundleProduct.add(pro6);
		listBundles.add(new Bundle(5, "Gold", goldBundleProduct, 3, 17, 40000, false));
	}

}
