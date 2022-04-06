package com.sarat.the_retail_store_discounts.com.sarat.retailStore.model;

public interface Products {

    String getProductName();
    ProductType getProductType();
    double getProductUnitPrice();
    double getTotalPrice(int quantity);
}
