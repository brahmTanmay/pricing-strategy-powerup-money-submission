package com.phonepe.platform;

import java.util.HashMap;
import java.util.Map;

public class CouponDiscountService implements DiscountService {
    private final Map<Integer, CouponDiscount> couponDiscounts = new HashMap<>();

    public void addDiscount(CouponDiscount discount) {
        couponDiscounts.put(discount.getCouponId(), discount);
    }

    @Override
    public DiscountType getDiscountType() { return DiscountType.COUPON; }

    @Override
    public void applyDiscount(Cart cart) {
        Coupon coupon = cart.getCoupon();
        if (coupon == null) return;
        CouponDiscount discount = couponDiscounts.get(coupon.couponId());
        if (discount == null) return;

        for (Product product : cart.getProducts()) {
            if (coupon.referenceProductId() == null || coupon.referenceProductId() == product.getProductId()) {
                product.addDiscount(discount.getDiscountPercentage());
            }
        }
    }
}
