package com.phonepe.platform;

public class ConditionalDiscount extends Discount {
    private final double thresholdValue;

    public ConditionalDiscount(int discountId, double discountPercentage, double thresholdValue) {
        super(DiscountType.CONDITIONAL_DISCOUNT, discountId, discountPercentage);
        this.thresholdValue = thresholdValue;
    }

    public double getThresholdValue() { return thresholdValue; }
}
