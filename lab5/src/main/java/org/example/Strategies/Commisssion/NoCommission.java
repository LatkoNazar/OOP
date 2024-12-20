package org.example.Strategies.Commisssion;

public class NoCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(double amount) {
        return 0;
    }
}
