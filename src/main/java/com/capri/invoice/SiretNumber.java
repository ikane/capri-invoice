package com.capri.invoice;

public record SiretNumber(String siretNumber) {
    public SiretNumber {
        if (siretNumber == null || siretNumber.isBlank()) {
            throw new IllegalArgumentException("Siret number cannot be null or blank");
        }
        // siretNumber should be of pattern 12345678912345
        if (!siretNumber.matches("\\d{14}")) {
            throw new IllegalArgumentException("Siret number should be of pattern 12345678912345");
        }
    }
}
