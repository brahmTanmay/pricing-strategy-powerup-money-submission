package com.phonepe.platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();
    private Coupon coupon;

    public Cart(List<Product> products) {
        this.products.addAll(products);
    }

    public List<Product> getProducts() { return Collections.unmodifiableList(products); }
    public Coupon getCoupon() { return coupon; }
    public void addCoupon(Coupon coupon) { this.coupon = coupon; }
    public void updateCoupon(Coupon coupon) { this.coupon = coupon; }
    public void removeCoupon() { this.coupon = null; }

    public double getBaseTotal() {
        return products.stream().mapToDouble(p -> p.getBasePrice() * p.getTotalCount()).sum();
    }

    public double getCurrentTotal() {
        double total = products.stream().mapToDouble(p -> p.getPrice() * p.getTotalCount()).sum();
        return Math.round(total * 100.0) / 100.0;
    }
}
