package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Product {
    private int countProducts;
    private long id;
    private String name;
    private double deliveryPrice;
    private ProductCategory productCategory;
    private LocalDate expirationDate;

    public Product(long id, String name, double deliveryPrice, ProductCategory productCategory, LocalDate expirationDate) {
        countProducts++;
        this.id = id;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
        this.productCategory = productCategory;
        this.expirationDate = expirationDate;
    }

    public int getCountProducts() {
        return countProducts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public double calculateSalePrice(double markupPercentageFood, double markupPercentageNonFood, int daysToExpiration, double percentageDiscount){
        if(this.expirationDate.compareTo(LocalDate.now()) < 0){
            return 0; // the product can't be sold, because the expiration date has expired
        }
        if(ChronoUnit.DAYS.between(LocalDate.now(), this.expirationDate) < daysToExpiration ){
            this.deliveryPrice -= this.deliveryPrice*(percentageDiscount/100);
        }
        if(this.productCategory.equals(ProductCategory.FOOD)){
            this.deliveryPrice += this.deliveryPrice*(markupPercentageFood/100);
        }
        else if(productCategory.equals(ProductCategory.NON_FOOD)){
            this.deliveryPrice+=this.deliveryPrice*(markupPercentageNonFood/100);
        }
        return this.deliveryPrice;
    }


}
