package org.example.Strategies.Commisssion;

public class FixedRateCommissionStrategy implements CommissionStrategy {
    private double rate;

    public FixedRateCommissionStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateCommission(double amount) {
        return amount * rate;
    }
}