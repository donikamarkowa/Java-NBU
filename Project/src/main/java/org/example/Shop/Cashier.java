package org.example.Shop;

import java.math.BigDecimal;

public class Cashier {
    private String name;
    private long id;
    private BigDecimal salaryForOneMonth;

    public Cashier(String name, long id, BigDecimal salaryForOneMonth) {
        this.name = name;
        this.id = id;
        this.salaryForOneMonth = salaryForOneMonth;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getSalaryForOneMonth() {
        return salaryForOneMonth;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salaryForOneMonth=" + salaryForOneMonth +
                '}';
    }
}
