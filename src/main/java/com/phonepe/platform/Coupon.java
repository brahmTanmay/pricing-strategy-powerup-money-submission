package com.phonepe.platform;

public record Coupon(int couponId, Integer referenceProductId, String couponDetails) {
    public Coupon(int couponId, String couponDetails) {
        this(couponId, null, couponDetails);
    }
}
