package com.phonepe.platform;

public class ProductDiscount extends Discount {
    private final int productId;

    public ProductDiscount(int discountId, double discountPercentage, int productId) {
        super(DiscountType.PRODUCT_DISCOUNT, discountId, discountPercentage);
        this.productId = productId;
    }

    public int getProductId() { return productId; }
}
