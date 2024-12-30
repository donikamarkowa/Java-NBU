package org.example;

import java.math.BigDecimal;

public enum TypeContract {
    PERMANENT(BigDecimal.ZERO),
    PART_TIME(BigDecimal.ZERO),
    TRAINEE(BigDecimal.ZERO);

    public BigDecimal minPricePerHour;

    TypeContract(BigDecimal minPricePerHour){
        setMinPricePerHour(minPricePerHour);
    }

    public BigDecimal getMinPricePerHour() {
        return minPricePerHour;
    }

    public void setMinPricePerHour(BigDecimal minPricePerHour) {
        this.minPricePerHour = minPricePerHour;
    }

}
