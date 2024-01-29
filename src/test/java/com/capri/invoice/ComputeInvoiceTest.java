package com.capri.invoice;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.withinPercentage;

class ComputeInvoiceTest {
    ComputeInvoice computeInvoice = new ComputeInvoice();
    @Test
    void givenRetailCustomerWhenComputeCustomerInvoiceForElectricityThenReturnCorrectAmount() {
       // Given
        final var customerReference = new CustomerReference("EKW111111111");
        final var customer = new RetailCustomer(customerReference, Civility.MADAME, "John", "Doe");
        final var energyConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 1000);

       // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

       // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(133), withinPercentage(0.01));
    }

    @Test
    void givenRetailCustomerWhenComputeCustomerInvoiceForGasThenReturnCorrectAmount() {
        // Given
        final var customerReference = new CustomerReference("EKW111111111");
        final var customer = new RetailCustomer(customerReference, Civility.MADAME, "John", "Doe");
        final var energyConsumption = new EnergyConsumption(EnergyType.GAS, 1000);

        // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

        // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(108), withinPercentage(0.01));
    }

    @Test
    void givenBusinessCustomerWithOneMillionRevenueWhenComputeCustomerInvoiceForElectricityThenReturnCorrectAmount() {
        // Given
        final var customerReference = new CustomerReference("EKW222222222");
        final var revenue = new Revenue(1_500_000);
        final var customer = new BusinessCustomer(customerReference, "ACME", new SiretNumber("12345678901234"), revenue);
        final var energyConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 1000);

        // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

        // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(110), withinPercentage(0.01));
    }

    @Test
    void givenBusinessCustomerWithOneMillionRevenueWhenComputeCustomerInvoiceForGasThenReturnCorrectAmount() {
        // Given
        final var customerReference = new CustomerReference("EKW222222222");
        final var revenue = new Revenue(1_500_000);
        final var customer = new BusinessCustomer(customerReference, "ACME", new SiretNumber("12345678901234"), revenue);
        final var energyConsumption = new EnergyConsumption(EnergyType.GAS, 1000);

        // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

        // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(123), withinPercentage(0.01));
    }

    @Test
    void givenBusinessCustomerWithLessThanOneMillionRevenueWhenComputeCustomerInvoiceForElectricityThenReturnCorrectAmount() {
        // Given
        final var customerReference = new CustomerReference("EKW333333333");
        final var revenue = new Revenue(500_000);
        final var customer = new BusinessCustomer(customerReference, "ACME2", new SiretNumber("45661234565411"), revenue);
        final var energyConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 1000);

        // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

        // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(112), withinPercentage(0.01));
    }

    @Test
    void givenBusinessCustomerWithLessThanOneMillionRevenueWhenComputeCustomerInvoiceForGasThenReturnCorrectAmount() {
        // Given
        final var customerReference = new CustomerReference("EKW333333333");
        final var revenue = new Revenue(500_000);
        final var customer = new BusinessCustomer(customerReference, "ACME2", new SiretNumber("45661234565411"), revenue);
        final var energyConsumption = new EnergyConsumption(EnergyType.GAS, 1000);

        // When
        final var result = computeInvoice.computeCustomerInvoice(customer, energyConsumption);

        // Then
        assertThat(result).isCloseTo(BigDecimal.valueOf(117), withinPercentage(0.01));
    }
}
