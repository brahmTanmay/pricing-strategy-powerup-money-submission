package com.phonepe.platform;



public class CategoryDiscount extends Discount {
    private final int categoryId;

    public CategoryDiscount(int discountId, double discountPercentage, int categoryId) {
        super(DiscountType.CATEGORY_DISCOUNT, discountId, discountPercentage);
        this.categoryId = categoryId;
    }

    public int getCategoryId() { return categoryId; }
}
