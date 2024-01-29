package com.capri.invoice;

public record Revenue(long value) {
    public Revenue {
        if (value < 0) {
            throw new IllegalArgumentException("Revenue cannot be negative");
        }
    }

    public boolean moreThanOneMillion() {
        return value >= 1_000_000;
    }
}
