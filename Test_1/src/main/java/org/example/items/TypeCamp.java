package org.example.items;

public enum TypeCamp {
    SPORT(5), EDUCATIONAL(10);

    private double costForTypeCamp;

    TypeCamp(double costForTypeCamp) {
        this.costForTypeCamp = costForTypeCamp;
    }

    public double getCostForTypeCamp() {
        return costForTypeCamp;
    }

    public void setCostForTypeCamp(double costForTypeCamp) {
        this.costForTypeCamp = costForTypeCamp;
    }
}
