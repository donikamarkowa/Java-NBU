package org.example.items;

import org.example.exceptions.NegativeOverchargePercentageException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medicine extends Item{
    private LocalDate expiryDate;
    private AgeCategory ageCategory;

    public Medicine(String inventoryNumber, String name, double deliveryPrice, LocalDate expiryDate, AgeCategory ageCategory) {
        super(inventoryNumber, name, deliveryPrice);
        this.expiryDate = expiryDate;
        this.ageCategory = ageCategory;
    }


    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public long daysToExpiration(){
        return ChronoUnit.DAYS.between(LocalDate.now(), this.expiryDate);
    }

    @Override
    public double sellingPrice(double overchargePercentage)
            throws NegativeOverchargePercentageException {
        return super.sellingPrice(overchargePercentage)
                - super.sellingPrice(overchargePercentage)
                * this.ageCategory.getReductionPercentage()/100;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "expiryDate=" + expiryDate +
                ", ageCategory=" + ageCategory +
                '}';
    }
}
