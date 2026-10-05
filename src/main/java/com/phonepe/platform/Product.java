package com.phonepe.platform;

/*
//

pricing engine for a ecommerce platform



Requirements

Assumptions
1. all the products are already added within the user cart, and all the discount are applied on that


1. we will have a list of products
2. Each product will have a base price
3. the product price can be dynamically changed with different strategies
4. we will have a get api to fetch the current price of the product
5. we should have api's to dynamically alter the product price based on business case [discounts, coupon]
Note -: discount and coupon can be applied to the one or all the products

Discount

1. categories based discount
2. coupon based discount
3. conditional based discount
4. product level discount

total discount on a product = aggregate of all discounts applicable




Classes


Category

+ type enum [ELECTRONICS, BOOKS]
+ categoryId


Product

+ productId
+ productName
+ productDescription
+ productS3url
+ price
+ totalCount
+ categoryId
+ .. other metas



Coupon
+ couponId
+ referenceId
+ couponDetails


Discount
+ type enum [CATEGORY_DISCOUNT, COUPAN, PRODUCT_DISCOUNT, CONDITIONAL_DISCOUNT]
+ discountId
+ discountPercentage
+ categoryId
+ productId
+ coupanId
+ thresholdValue



CategoryDiscount extends Discount
+ type -: CATEGORY_DISCOUNT
+ categoryId

ProductDiscount extends Discount
+ type -; PRODUCT_DISCOUNT
+ productId
..





Cart

List<Product> products;
Coupon coupon;

-: applyDiscountOnCart() -: apply discount on all the products in the cart


- addCoupon
- updateCoupon
- removeCoupon



BridgeService // works like factory method
Map<DiscountType, DiscountService> discountService;
List<

- applyDiscountOnCart(Cart cart); // calls the discount service to fetch all the discount available on the carts.
- addDiscountService(DiscountService discountService); // add more discount service within the bridge service




Interface DiscountService
- applyDiscount(Cart cart);


CategoryDiscountService implements DiscountService
+ Map<Integer, CategoryDiscount> categoryDiscount
- applyDiscount(Cart cart);



ProductDiscountService implements DiscountService
+ Map<Integer, ProductDiscount> productDiscount
- applyDiscount(Cart cart);


CouponDiscountService implements DiscountService
Map<Integer, CouponDiscount> couponDiscount
- applyDiscount(Cart cart);



ConditionalDiscountService implements DiscountService
int threshold
ConditionalDiscount discount;

- applyDiscount(List<Product> products);

 */


public class Product {
    private final int productId;
    private final String productName;
    private final String productDescription;
    private final String productS3Url;
    private final double basePrice;
    private final int totalCount;
    private final int categoryId;
    private double price;
    private double totalDiscountPercentage;

    public Product(int productId, String productName, double basePrice, int totalCount, int categoryId) {
        this(productId, productName, "", "", basePrice, totalCount, categoryId);
    }

    public Product(int productId, String productName, String productDescription, String productS3Url,
                   double basePrice, int totalCount, int categoryId) {
        if (basePrice < 0 || totalCount < 0) throw new IllegalArgumentException("Price and quantity cannot be negative");
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productS3Url = productS3Url;
        this.basePrice = basePrice;
        this.price = basePrice;
        this.totalCount = totalCount;
        this.categoryId = categoryId;
    }

    public void resetPrice() {
        totalDiscountPercentage = 0;
        price = basePrice;
    }

    public void addDiscount(double percentage) {
        totalDiscountPercentage += percentage;
        double effectiveDiscount = Math.min(100, totalDiscountPercentage);
        price = Math.round(basePrice * (100 - effectiveDiscount)) / 100.0;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getProductDescription() { return productDescription; }
    public String getProductS3Url() { return productS3Url; }
    public double getBasePrice() { return basePrice; }
    public double getPrice() { return price; }
    public int getTotalCount() { return totalCount; }
    public int getCategoryId() { return categoryId; }
    public double getTotalDiscountPercentage() { return totalDiscountPercentage; }
}
