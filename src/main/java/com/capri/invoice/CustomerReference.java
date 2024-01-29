package com.capri.invoice;

public record CustomerReference(String reference) {
    public CustomerReference {
        if (reference == null || reference.isBlank()) {
            throw new IllegalArgumentException("Customer reference cannot be null or blank");
        }
        // reference should should be of pattern EKW123456789
        if (!reference.matches("EKW\\d{9}")) {
            throw new IllegalArgumentException("Customer reference should be of pattern EKW123456789");
        }
    }
}
