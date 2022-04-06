package com.sarat.the_retail_store_discounts;

import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.*;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.Cart;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TestWithoutDiscounts {

    private Cart cart;
    private Products products;
    private Discounts discounts;

    @Before
    public void setUp() {
    	User user = new User("Sumit", "7829386666", LocalDateTime.now(), LocalDateTime.now(), UserType.GENERAL);
        discounts = new StoreDiscounts();
        cart = new ShoppingCart(discounts, user);
        products = new Product("something", 9, ProductType.SPORTS);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.totalAmount(), 0.01);
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.addProducts(products, 1);
        assertEquals(products.getProductUnitPrice(), cart.totalAmount(), 0.01);
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int quantity = 3;
        cart.addProducts(products, quantity);
        assertEquals(quantity * products.getProductUnitPrice(), cart.totalAmount(), 0.01);
    }

    @Test
    public void test_separatelyAdding() {
        int quantity = 3;
        for (int i = quantity; i > 0; i--) {
            cart.addProducts(products, 1);
        }
        assertEquals(quantity * products.getProductUnitPrice(), cart.totalAmount(), 0.01);
    }
}
