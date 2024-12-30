package org.example.Goods;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Good {
    private final long id;
    private String name;
    private BigDecimal deliveryPrice;
    private GoodCategory goodCategory;
    private LocalDate expireDate;

    public Good(long id, String name, BigDecimal deliveryPrice, GoodCategory goodCategory, LocalDate expireDate) {
        this.id = id;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
        this.goodCategory = goodCategory;
        this.expireDate = expireDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public int daysToExpire(Good good){
        return (int)ChronoUnit.DAYS.between(LocalDate.now(), good.getExpireDate());
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", goodCategory=" + goodCategory +
                ", expireDate=" + expireDate +
                '}';
    }
}
