package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Company {
    private String companyName;
    private int maxNumberOfEmployees;

    private List<Employee> employeeList;

    public Company(String companyName, int maxNumberOfEmployees) {
        this.companyName = companyName;
        this.maxNumberOfEmployees = maxNumberOfEmployees;
        this.employeeList = new ArrayList<>();
    }

    public boolean hireEmployee(Employee employee){
        if(employeeList.contains((employee)) || maxNumberOfEmployees == employeeList.size()){
            return false;
        }
        return this.employeeList.add(employee);
    }

    public boolean fireEmployee(Employee employee){
        if(this.employeeList.contains(employee)){
            return this.employeeList.remove(employee);
        }
        return false;
    }

    public BigDecimal averageSalary(){
        BigDecimal sum = new BigDecimal(0);
        int numEmployees = employeeList.size();
        if(numEmployees != 0){
            for(Employee employee : this.employeeList){
                sum = sum.add(employee.getSalary());
            }
            sum = sum.divide(BigDecimal.valueOf(numEmployees), 2, RoundingMode.HALF_UP);
            return sum;
        }

        return BigDecimal.ZERO;
    }

    public void increaseSalaries(BigDecimal percentage){
        if(percentage.compareTo((BigDecimal.ZERO)) ==  1){
            BigDecimal increasePercentage = percentage.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            for(Employee employee : this.employeeList){
                employee.setAdditionalSalary(employee.getAdditionalSalary().multiply(increasePercentage).add(employee.getAdditionalSalary()));
                BigDecimal newSalary = employee.getHoursWorked().multiply(employee.getSalaryPerHour());
                employee.setSalary(newSalary);
            }
        }
    }

    public BigDecimal averageSalaryPerContractType(TypeContract typeContract){
        BigDecimal sum = new BigDecimal(0);
        int numEmployees = 0;
        for(Employee employee : this.employeeList){
            if(employee.getTypeContract().equals(typeContract)){
                numEmployees++;
                sum = sum.add(employee.getSalary());
            }
        }
        if(numEmployees != 0){
            sum = sum.divide(BigDecimal.valueOf(numEmployees), 2, RoundingMode.HALF_UP);
            return sum;
        }
        return BigDecimal.ZERO;

    }

}
