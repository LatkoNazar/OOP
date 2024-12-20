package org.example.Adapters;

public interface PaymentProcessor {
    void processPayment(double amount);
    double  calculateCommission(double amount);
    double getBalance();
}