package com.sarat.the_retail_store_discounts.com.sarat.retailStore.service;

import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.Products;
import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.User;

public interface Cart {
    void addProducts(Products products, int quantity);
    int checkUserTypeAndGetDiscounts(User user);
    double totalAmount();
}
