package com.sarat.the_retail_store_discounts;

import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.*;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.Bill;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.Cart;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.Receipt;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.service.ShoppingCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TheRetailStoreDiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheRetailStoreDiscountsApplication.class, args);

		User sarat = new User("Sarat", "7829386014", LocalDateTime.now(), LocalDateTime.now(), UserType.EMPLOYEE);
		Products grocery = new Product("Sugar", 40, ProductType.GROCERY);
		Products cloth = new Product("T-Shirt", 900, ProductType.CLOTHING);

		Discounts discounts = new StoreDiscounts();
		Cart cart = new ShoppingCart(discounts, sarat);
		cart.addProducts(grocery, 2);
		cart.addProducts(cloth, 1);

		//System.out.println(cart.totalAmount());
		Bill bill = new Receipt();
		bill.printBill(cart);

	}

}
