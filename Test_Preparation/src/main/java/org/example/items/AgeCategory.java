package org.example.items;

public enum AgeCategory {
    ADULTS(10), TEENAGERS(20), CHILDREN(30);

    private double reductionPercentage;

    AgeCategory(double reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public double getReductionPercentage() {
        return reductionPercentage;
    }

    public void setReductionPercentage(double reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }
}
