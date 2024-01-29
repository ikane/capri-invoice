package com.capri.invoice;

public record EnergyConsumption(EnergyType energyType, double consumption) {
    public EnergyConsumption {
        if (energyType == null) {
            throw new IllegalArgumentException("Energy type cannot be null");
        }
        if (consumption < 0) {
            throw new IllegalArgumentException("Consumption cannot be negative");
        }
    }
}
