package org.example.company;

import org.example.exceptions.NegativeOverchargePercentageException;
import org.example.items.Sellable;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private double overchargePercentage;
    private List<Sellable> sellableList;

    public Pharmacy(double overchargePercentage) {
        this.overchargePercentage = overchargePercentage;
        this.sellableList = new ArrayList<>();
    }

    public double getOverchargePercentage() {
        return overchargePercentage;
    }

    public boolean addSellable(Sellable sellable){
        return this.sellableList.add(sellable);
    }

    public double totalIncome()
        throws NegativeOverchargePercentageException{
        double totalIncome = 0;
        for(Sellable sellable : this.sellableList){
            totalIncome += sellable.sellingPrice(this.overchargePercentage);
        }
        return totalIncome;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "overchargePercentage=" + overchargePercentage +
                ", sellableList=" + sellableList +
                '}';
    }
}
