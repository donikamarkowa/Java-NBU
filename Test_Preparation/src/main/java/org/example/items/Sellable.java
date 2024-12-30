package org.example.items;

import org.example.exceptions.NegativeOverchargePercentageException;

public interface Sellable {
    default double sellingPrice(double overchargePercentage)
        throws NegativeOverchargePercentageException{
        if(overchargePercentage < 0){
            throw new NegativeOverchargePercentageException("Overcharge percentage has to be NONegative!", overchargePercentage);
        }
        return 0;
    }
}
