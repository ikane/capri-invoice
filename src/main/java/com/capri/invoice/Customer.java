package com.capri.invoice;

public sealed interface Customer permits RetailCustomer, BusinessCustomer {
}
