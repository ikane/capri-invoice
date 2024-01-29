package com.capri.invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerReferenceTest {

    @Test
    void should_throw_exception_when_customer_reference_is_null() {
        assertThrows(IllegalArgumentException.class, () -> new CustomerReference(null));
    }

    @Test
    void should_throw_exception_when_customer_reference_is_blank() {
        assertThrows(IllegalArgumentException.class, () -> new CustomerReference(""));
    }

    @Test
    void should_throw_exception_when_customer_reference_is_in_incorrect_format() {
        assertThrows(IllegalArgumentException.class,
                () -> new CustomerReference("ABC123456789"),
                "Customer reference should be of pattern EKW123456789");
    }
}