package org.example.Adapters;
import org.example.API.StripeAPI;
import org.example.Strategies.Commisssion.TieredCommissionStrategy;

public class StripeAdapter implements PaymentProcessor {
    private StripeAPI StripeAPI;
    TieredCommissionStrategy tieredCommissionStrategy = new TieredCommissionStrategy();

    public StripeAdapter(StripeAPI stripeAPI) {
        this.StripeAPI = stripeAPI;
    }

    @Override
    public void processPayment(double amount) {
        StripeAPI.makeStripePayment(amount);
    }

    @Override
    public double calculateCommission(double amount) {
        return tieredCommissionStrategy.calculateCommission(amount);
    }

    @Override
    public double getBalance() {
        return StripeAPI.getBalance();
    }
}