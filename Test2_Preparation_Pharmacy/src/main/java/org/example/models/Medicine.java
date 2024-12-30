package org.example.models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Medicine implements Comparable<Medicine> {
    private UUID uuid;
    private String name;
    private AgeCategory ageCategory;
    private LocalDate productionDate;

    public Medicine(String name, AgeCategory ageCategory, LocalDate productionDate) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.ageCategory = ageCategory;
        this.productionDate = productionDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(uuid, medicine.uuid) && Objects.equals(name, medicine.name) && ageCategory == medicine.ageCategory && Objects.equals(productionDate, medicine.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public int compareTo(Medicine o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", ageCategory=" + ageCategory +
                ", productionDate=" + productionDate +
                '}';
    }
}
