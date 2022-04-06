package com.sarat.the_retail_store_discounts.com.sarat.retailStore.service;

import com.sarat.the_retail_store_discounts.com.sarat.retailStore.model.*;
import lombok.*;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShoppingCart implements Cart{

    @Getter @Setter
    private Map<Products, Integer> productQuantityMap;
    private Discounts discounts;
    private User user;

    public ShoppingCart(Discounts discounts, User user) {
        productQuantityMap = new LinkedHashMap<>();
        this.discounts = discounts;
        this.user = user;
    }

    @Override
    public void addProducts(Products products, int quantity) {

        int storedQuantity = productQuantityMap.getOrDefault(products, 0);
        productQuantityMap.put(products, storedQuantity + quantity);
    }

    @Override
    public int checkUserTypeAndGetDiscounts(User user) {
        if(user.getUserType() == UserType.EMPLOYEE) return 30;
        else if (user.getUserType() == UserType.AFFILIATE) return 10;
        else if (user.getUserType() == UserType.GENERAL && ChronoUnit.YEARS.between(user.getRegisteredDateAndTime(), LocalDateTime.now()) >= 2) return 5;
        else return 0;
    }

    @Override
    public double totalAmount() {
        double total = 0;
        for (Products product : productQuantityMap.keySet()) {
            double productPrice = product.getTotalPrice(productQuantityMap.get(product));
            if(product.getProductType() != ProductType.GROCERY) {
                total = total + (productPrice - (productPrice * checkUserTypeAndGetDiscounts(user) / 100));
            } else {
                total = total + productPrice;
            }

        }

        if(discounts != null) total = discounts.applyDiscount(total);
        
        return total;
    }
}
