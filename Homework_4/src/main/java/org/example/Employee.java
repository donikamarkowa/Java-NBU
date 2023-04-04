package org.example;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private long Id;

    public TypeContract typeContract;
    private BigDecimal hoursWorked;

    private BigDecimal additionalSalary = new BigDecimal(0);
    private BigDecimal salary = new BigDecimal(0);
    private BigDecimal salaryPerHour = new BigDecimal(0);

    public Employee(String name, TypeContract typeContract, BigDecimal hoursWorked, BigDecimal additionalSalary) {
        this.name = name;
        this.typeContract = typeContract;
        this.hoursWorked = hoursWorked;
        this.additionalSalary = additionalSalary;
    }

    public String getName() {
        return name;
    }

    public TypeContract getTypeContract() {
        return typeContract;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public BigDecimal getAdditionalSalary() {
        return additionalSalary;
    }

    public BigDecimal getSalary() {
        return getHoursWorked().multiply(getSalaryPerHour());
    }

    public BigDecimal getSalaryPerHour() {
        return this.salaryPerHour.add(this.typeContract.getMinPricePerHour()).add(getAdditionalSalary());
    }

    public void setAdditionalSalary(BigDecimal additionalSalary){
        this.additionalSalary = additionalSalary;
    }

    public void setSalary(BigDecimal salary){
        this.salary = salary;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour){
        this.salaryPerHour = salaryPerHour;
    }

    public BigDecimal increaseSalary(BigDecimal additionalSalary){
        BigDecimal newSalary = new BigDecimal(0);
        BigDecimal salary = this.hoursWorked.multiply(this.typeContract.getMinPricePerHour());
        if(additionalSalary.compareTo(BigDecimal.ZERO) > 0){
            newSalary = additionalSalary.multiply(salary).divide(BigDecimal.valueOf(100)).add(salary);
            return newSalary;
        }
        return additionalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", typeContract=" + typeContract +
                ", hoursWorked=" + hoursWorked +
                ", additionalSalary=" + additionalSalary +
                ", salary=" + salary +
                ", salaryPerHour=" + salaryPerHour +
                '}';
    }
}
