package com.phonepe.platform;

import java.util.HashMap;
import java.util.Map;

public class CategoryDiscountService implements DiscountService {
    private final Map<Integer, CategoryDiscount> categoryDiscounts = new HashMap<>();

    public void addDiscount(CategoryDiscount discount) {
        categoryDiscounts.put(discount.getCategoryId(), discount);
    }

    @Override
    public DiscountType getDiscountType() { return DiscountType.CATEGORY_DISCOUNT; }

    @Override
    public void applyDiscount(Cart cart) {
        for (Product product : cart.getProducts()) {
            CategoryDiscount discount = categoryDiscounts.get(product.getCategoryId());
            if (discount != null) product.addDiscount(discount.getDiscountPercentage());
        }
    }
}
