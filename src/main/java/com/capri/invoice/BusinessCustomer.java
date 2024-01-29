package com.capri.invoice;

public record BusinessCustomer(CustomerReference customerReference, String companyName, SiretNumber siretNumber, Revenue revenue) implements Customer {
    public BusinessCustomer {
        if (customerReference == null) {
            throw new IllegalArgumentException("Customer reference cannot be null");
        }
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank");
        }
        if (siretNumber == null) {
            throw new IllegalArgumentException("Siret number cannot be null");
        }
        if (revenue == null) {
            throw new IllegalArgumentException("Revenue cannot be null");
        }
    }
}
