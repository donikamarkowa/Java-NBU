package org.example.models;

import java.util.*;
public class Pharmacy {
    private String name;
    private Map<Medicine, Double> medicinesSellingPrice;
    private Set<Medicine> promotedMedicines;

    public Pharmacy(String name) {
        this.name = name;
        this.medicinesSellingPrice = new HashMap<Medicine, Double>();
        this.promotedMedicines = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Map<Medicine, Double> getMedicinesSellingPrice() {
        return medicinesSellingPrice;
    }

    public Set<Medicine> getPromotedMedicines() {
        return promotedMedicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +
                '}';
    }
}
