package com.phonepe.platform;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 1000, 1, 10);
        Product book = new Product(2, "Book", 100, 2, 20);
        Cart cart = new Cart(List.of(laptop, book));
        cart.addCoupon(new Coupon(101, "Festival coupon"));

        CategoryDiscountService categories = new CategoryDiscountService();
        categories.addDiscount(new CategoryDiscount(1, 10, 10));
        ProductDiscountService products = new ProductDiscountService();
        products.addDiscount(new ProductDiscount(2, 5, 1));
        CouponDiscountService coupons = new CouponDiscountService();
        coupons.addDiscount(new CouponDiscount(3, 5, 101));

        BridgeService bridge = new BridgeService();
        bridge.addDiscountService(categories);
        bridge.addDiscountService(products);
        bridge.addDiscountService(coupons);
        bridge.addDiscountService(new ConditionalDiscountService(new ConditionalDiscount(4, 5, 1000)));
        bridge.applyDiscountOnCart(cart);

        cart.getProducts().forEach(product ->
                System.out.println(product.getProductName() + ": " + product.getPrice()));
        System.out.println("Cart total: " + cart.getCurrentTotal());
    }
}
