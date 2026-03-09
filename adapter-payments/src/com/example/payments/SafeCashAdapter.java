package com.example.payments;

public class SafeCashAdapter implements PaymentGateway{
    private final SafeCashClient cl;
    public SafeCashAdapter(SafeCashClient cl) {
        this.cl = cl;
    }
    public String charge(String user, int amount) {
        SafeCashPayment payment = cl.createPayment(amount, user);
        return payment.confirm();
    }

}