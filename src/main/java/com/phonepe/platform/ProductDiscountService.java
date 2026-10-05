package com.phonepe.platform;

import java.util.HashMap;
import java.util.Map;

public class ProductDiscountService implements DiscountService {
    private final Map<Integer, ProductDiscount> productDiscounts = new HashMap<>();

    public void addDiscount(ProductDiscount discount) {
        productDiscounts.put(discount.getProductId(), discount);
    }

    @Override
    public DiscountType getDiscountType() { return DiscountType.PRODUCT_DISCOUNT; }

    @Override
    public void applyDiscount(Cart cart) {
        for (Product product : cart.getProducts()) {
            ProductDiscount discount = productDiscounts.get(product.getProductId());
            if (discount != null) product.addDiscount(discount.getDiscountPercentage());
        }
    }
}
