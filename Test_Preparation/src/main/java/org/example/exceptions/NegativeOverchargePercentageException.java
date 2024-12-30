package org.example.exceptions;

public class NegativeOverchargePercentageException extends Exception{
    private double overchargePercentage;

    public NegativeOverchargePercentageException(String message, double overchargePercentage){
        super(message);
        this.overchargePercentage = overchargePercentage;
    }

    @Override
    public String toString() {
        return "NegativeOverchargePercentageException{" +
                "overchargePercentage=" + overchargePercentage +
                '}';
    }
}
