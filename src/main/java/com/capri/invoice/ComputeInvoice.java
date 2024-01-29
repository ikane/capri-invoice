package com.capri.invoice;

import java.math.BigDecimal;

public class ComputeInvoice {
    public BigDecimal computeCustomerInvoice(Customer customer, EnergyConsumption energyConsumption) {
        return switch (customer) {
            case RetailCustomer ignored -> computeRetailCustomerInvoice(energyConsumption);
            case BusinessCustomer businessCustomer -> computeBusinessCustomerInvoice(energyConsumption, businessCustomer.revenue());
        };
    }

    private BigDecimal computeRetailCustomerInvoice(EnergyConsumption energyConsumption) {
        final var energyType = energyConsumption.energyType();
        final var consumption = energyConsumption.consumption();
        return switch (energyType) {
            case ELECTRICITY -> BigDecimal.valueOf(0.133 * consumption);
            case GAS -> BigDecimal.valueOf(0.108 * consumption);
        };
    }

    private BigDecimal computeBusinessCustomerInvoice(EnergyConsumption energyConsumption, Revenue revenue) {
        final var energyType = energyConsumption.energyType();
        final var consumption = energyConsumption.consumption();

        if(revenue.moreThanOneMillion()) {
            return switch (energyType) {
                case ELECTRICITY -> BigDecimal.valueOf(0.110 * consumption);
                case GAS -> BigDecimal.valueOf(0.123 * consumption);
            };
        } else {
            return switch (energyType) {
                case ELECTRICITY -> BigDecimal.valueOf(0.112 * consumption);
                case GAS -> BigDecimal.valueOf(0.117 * consumption);
            };
        }
    }
}
