package org.example.service;

import org.example.models.AgeCategory;
import org.example.models.Medicine;
import org.example.models.Pharmacy;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PharmacyServiceImpl implements PharmacyService{
    @Override
    public boolean addMedicinePrice(Pharmacy pharmacy, Medicine medicine, double sellingPrice) {
        return pharmacy.getMedicinesSellingPrice().put(medicine, sellingPrice) == null ? true : false;
    }

    @Override
    public boolean addPromotedMedicine(Pharmacy pharmacy, Medicine medicine) {
        return pharmacy.getPromotedMedicines().add(medicine);
    }

    @Override
    public void printMedicineSellingPrice(Pharmacy pharmacy) {
        pharmacy.getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }

    @Override
    public void printPromotedMedicines(Pharmacy pharmacy) {
        pharmacy.getPromotedMedicines()
                .stream()
                .forEach(System.out::println);
    }

    @Override
    public Set<Medicine> promotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory, String nameContains) {
        return pharmacy.getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getAgeCategory().equals(ageCategory)
                       && medicine.getName().contains(nameContains))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Medicine> promotedMedicinesProductionDateLessThenOrderByName(Pharmacy pharmacy, LocalDate productionDate) {
        return pharmacy.getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getProductionDate().isBefore(productionDate))
                .sorted(Comparator.comparing(Medicine::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public long numberOfPromotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory) {
        return pharmacy.getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getAgeCategory().equals(ageCategory))
                .count();
    }

    @Override
    public double medicinesSellingPriceTotalValue(Pharmacy pharmacy) {
        return pharmacy.getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .mapToDouble(entry -> entry.getValue())
                .sum();
    }

    @Override
    public double medicinesSellingPriceLeastValue(Pharmacy pharmacy) {
        return pharmacy.getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .mapToDouble(entry -> entry.getValue())
                .min()
                .getAsDouble();
    }

    @Override
    public Set<Medicine> medicinesSellingPriceBiggerThan(Pharmacy pharmacy, Double sellingPrice) {
        return pharmacy.getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > sellingPrice)
                .map(entry -> entry.getKey())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


}
