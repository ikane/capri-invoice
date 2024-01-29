package com.capri.invoice;
public record RetailCustomer(CustomerReference customerReference, Civility civility, String firstName, String lastName) implements Customer {
    public RetailCustomer {
        if (customerReference == null) {
            throw new IllegalArgumentException("Customer reference cannot be null");
        }
        if (civility == null) {
            throw new IllegalArgumentException("Civility cannot be null");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }
}
