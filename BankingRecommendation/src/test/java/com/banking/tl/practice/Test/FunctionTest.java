package com.banking.tl.practice.Test;

import java.util.List;

import com.banking.tl.practice.App;
import com.banking.tl.practice.models.Product;

import junit.framework.TestCase;

public class FunctionTest extends TestCase {

	/**
	 * Test junior bundle
	 */
	public void testBundleSuggesstion_Junior() {
		App.initializeData();
		assertEquals("0", App.bundleSuggestion(18, true, 41000));
	}

	/**
	 * Test junior bundle
	 */
	public void testBundleSuggesstion2_Junior() {
		App.initializeData();
		assertEquals("0", App.bundleSuggestion(5, false, 41000));
	}

	/**
	 * Test student bundle
	 */
	public void testBundleSuggesstion_Student() {
		App.initializeData();
		assertEquals("0", App.bundleSuggestion(18, true, 10000));
	}

	/**
	 * Test classic bundle
	 */
	public void testBundleSuggesstion_Classic() {
		App.initializeData();
		assertEquals("1", App.bundleSuggestion(18, false, 10000));
	}

	/**
	 * Test classic plus bundle
	 */
	public void testBundleSuggesstion_ClassicPlus() {
		App.initializeData();
		assertEquals("2", App.bundleSuggestion(18, false, 13000));
	}

	/**
	 * Test classic plus bundle
	 */
	public void testBundleSuggesstion_ClassicPlus2() {
		App.initializeData();
		assertEquals("2", App.bundleSuggestion(18, false, 25000));
	}

	/**
	 * Test gold bundle
	 */
	public void testBundleSuggesstion_Gold() {
		App.initializeData();
		assertEquals("3", App.bundleSuggestion(18, false, 43000));
	}

	/**
	 * Test remove product in bundle
	 */
	public void removeProductInBundle_Ok() {
		App.initializeData();
		assertTrue(App.removeProduct(1, 1));
	}

	/**
	 * test remove product but it not in bundle
	 */
	public void removeProductInBundle_NotOk() {
		App.initializeData();
		// don't have product 3 in bundle 1
		assertTrue(App.removeProduct(3, 1));
	}

	/**
	 * Test update product name with product id
	 */
	public void updateProduct() {
		App.initializeData();
		App.updateProduct(2, "Test");
		Product p = App.listProducts.stream().filter(s -> s.getId() == 1).findFirst().get();
		assertEquals("Test", p.getProductName());
	}

	/**
	 * Test add product to bundle
	 */
	public void addProduct() {
		App.initializeData();
		App.addProduct(1, 2);
		List<Product> list = App.listBundles.get(1).listProduct();
		assertEquals(4, list.size());
	}

	/**
	 * Test add debit card with correct condition
	 */
	public void addProductDebitCard_Ok() {
		App.initializeData();
		String rs = App.addProduct(7, 2);
		assertEquals("Success", rs);

	}

	/**
	 * Test add product is existed
	 */
	public void addProduct_IsAlreadyExisted() {
		App.initializeData();
		String rs = App.addProduct(4, 2);
		assertEquals("Product is already existed", rs);

	}

	/**
	 * Test add debit card with wrong condition
	 */
	public void addProductDebitCard_NotValid() {
		App.initializeData();
		String rs = App.addProduct(7, 1);
		assertEquals("Debit card can't add to this bundle", rs);

	}
}
