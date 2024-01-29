package com.capri.invoice;

import java.math.BigDecimal;

public record Price(BigDecimal amount) {
    public Price {
        if(amount == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
