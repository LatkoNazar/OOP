package org.example.Strategies.Commisssion;

public class TieredCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(double amount) {
        if (amount < 100) {
            return amount * 0.03;
        } else if (amount < 1000) {
            return amount * 0.015;
        } else {
            return amount * 0.01;
        }
    }
}