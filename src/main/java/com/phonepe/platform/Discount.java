package com.phonepe.platform;


public abstract class Discount {
    private final DiscountType discountType;
    private final int discountId;
    private final double discountPercentage;

    protected Discount(DiscountType discountType, int discountId, double discountPercentage) {
        if (discountPercentage < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.discountType = discountType;
        this.discountId = discountId;
        this.discountPercentage = discountPercentage;
    }

    public DiscountType getDiscountType() { return discountType; }
    public int getDiscountId() { return discountId; }
    public double getDiscountPercentage() { return discountPercentage; }
}
