package org.example.Adapters;

public interface PaymentProcessor {
    boolean processPayment(double amount, double balance);
    double  calculateCommission(double amount);
    double getBalance();
}