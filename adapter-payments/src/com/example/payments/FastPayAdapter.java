package com.example.payments;

public class FastPayAdapter implements PaymentGateway{
    private final FastPayClient cl;

    public FastPayAdapter(FastPayClient cl) {
        this.cl = cl;
    }

    public String charge(String custId, int amountCents) {
        return cl.payNow(custId, amountCents);
    }

}