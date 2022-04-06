package com.sarat.the_retail_store_discounts.com.sarat.retailStore.model;

public interface Discounts {
    DiscountType getDiscountType();
    double applyDiscount(double amount);
}
