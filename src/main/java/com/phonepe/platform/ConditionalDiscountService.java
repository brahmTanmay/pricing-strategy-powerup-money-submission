package com.phonepe.platform;

public class ConditionalDiscountService implements DiscountService {
    private ConditionalDiscount discount;

    public ConditionalDiscountService(ConditionalDiscount discount) {
        this.discount = discount;
    }

    public void updateDiscount(ConditionalDiscount discount) { this.discount = discount; }

    @Override
    public DiscountType getDiscountType() { return DiscountType.CONDITIONAL_DISCOUNT; }

    @Override
    public void applyDiscount(Cart cart) {
        if (discount != null && cart.getBaseTotal() >= discount.getThresholdValue()) {
            for (Product product : cart.getProducts()) {
                product.addDiscount(discount.getDiscountPercentage());
            }
        }
    }
}
