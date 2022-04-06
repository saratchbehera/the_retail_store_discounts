package com.sarat.the_retail_store_discounts.com.sarat.retailStore.service;

import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.Products;

public class Receipt implements Bill{
    @Override
    public void printBill(Cart cart) {
        System.out.println();
        //System.out.println(((ShoppingCart)cart).getProductQuantityMap());

        for(Products products: ((ShoppingCart)cart).getProductQuantityMap().keySet()) {
            System.out.println(products.getProductName() + " :: " + products.getProductType() + " :: " + products.getProductUnitPrice() + " :: "+ ((ShoppingCart)cart).getProductQuantityMap().get(products) + " :: " + products.getTotalPrice(((ShoppingCart)cart).getProductQuantityMap().get(products)));
        }

        System.out.println("Total Amount After Discount :: " + cart.totalAmount());

    }
}
