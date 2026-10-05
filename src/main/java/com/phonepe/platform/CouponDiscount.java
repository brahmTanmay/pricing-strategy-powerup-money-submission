package com.phonepe.platform;

public class CouponDiscount extends Discount {
    private final int couponId;

    public CouponDiscount(int discountId, double discountPercentage, int couponId) {
        super(DiscountType.COUPON, discountId, discountPercentage);
        this.couponId = couponId;
    }

    public int getCouponId() { return couponId; }
}
