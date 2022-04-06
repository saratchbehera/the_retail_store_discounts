package com.sarat.the_retail_store_discounts.com.sarat.retailStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String mobileNumber;
    private LocalDateTime registeredDateAndTime;
    private LocalDateTime purchaseDateAndTime;
    private UserType userType;
}
