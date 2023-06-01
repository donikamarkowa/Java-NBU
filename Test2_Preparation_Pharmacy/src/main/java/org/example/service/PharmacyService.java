package org.example.service;

import org.example.models.AgeCategory;
import org.example.models.Medicine;
import org.example.models.Pharmacy;

import java.time.LocalDate;
import java.util.Set;

public interface PharmacyService {
    boolean addMedicinePrice(Pharmacy pharmacy, Medicine medicine, double sellingPrice);

    boolean addPromotedMedicine(Pharmacy pharmacy, Medicine medicine);

    void printMedicineSellingPrice(Pharmacy pharmacy);

    void printPromotedMedicines(Pharmacy pharmacy);

    Set<Medicine> promotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory, String nameContains);

    Set<Medicine> promotedMedicinesProductionDateLessThenOrderByName(Pharmacy pharmacy, LocalDate productionDate);

    long numberOfPromotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory);

    double medicinesSellingPriceTotalValue(Pharmacy pharmacy);

    double medicinesSellingPriceLeastValue(Pharmacy pharmacy);

    Set<Medicine> medicinesSellingPriceBiggerThan(Pharmacy pharmacy, Double sellingPrice);

}
