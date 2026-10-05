package com.phonepe.platform;

public interface DiscountService {
    DiscountType getDiscountType();
    void applyDiscount(Cart cart);
}
