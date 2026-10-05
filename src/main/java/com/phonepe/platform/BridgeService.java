package com.phonepe.platform;

import java.util.EnumMap;
import java.util.Map;

public class BridgeService {
    private final Map<DiscountType, DiscountService> discountServices = new EnumMap<>(DiscountType.class);

    public void addDiscountService(DiscountService discountService) {
        discountServices.put(discountService.getDiscountType(), discountService);
    }

    public void applyDiscountOnCart(Cart cart) {
        cart.getProducts().forEach(Product::resetPrice);
        discountServices.values().forEach(service -> service.applyDiscount(cart));
    }
}
