package org.example.Adapters;
import org.example.API.PayPalAPI;
import org.example.Strategies.Commisssion.FixedRateCommissionStrategy;

public  class PayPalAdapter implements PaymentProcessor {
    private PayPalAPI PayPalAPI;
    FixedRateCommissionStrategy fixedRateCommissionStrategy = new FixedRateCommissionStrategy(0.02);

    public PayPalAdapter(PayPalAPI PayPalAPI) {
        this.PayPalAPI = PayPalAPI;
    }

    @Override
    public void processPayment(double amount) {
        PayPalAPI.payWithPayPal(amount);
    }

    @Override
    public double calculateCommission(double amount) {
        return fixedRateCommissionStrategy.calculateCommission(amount);
    }

    @Override
    public double getBalance() {
        return PayPalAPI.getBalance();
    }
}
