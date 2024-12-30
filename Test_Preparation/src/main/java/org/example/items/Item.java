package org.example.items;

import org.example.exceptions.NegativeOverchargePercentageException;

import java.io.Serializable;

public class Item implements Sellable, Serializable {
    private String inventoryNumber;
    private String name;
    private double deliveryPrice;

    public Item(String inventoryNumber, String name, double deliveryPrice) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getName() {
        return name;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    @Override
    public double sellingPrice(double overchargePercentage)
            throws NegativeOverchargePercentageException {
        return Sellable.super.sellingPrice(overchargePercentage)
                + this.deliveryPrice +
                this.deliveryPrice*overchargePercentage/100;
    }

    @Override
    public String toString() {
        return "Item{" +
                "inventoryNumber='" + inventoryNumber + '\'' +
                ", name='" + name + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
