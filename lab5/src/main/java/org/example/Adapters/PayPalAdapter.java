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
    public boolean processPayment(double amount, double balance) {
        if (balance < amount) {
            System.out.println("You do not have enough money!");
            return false;
        }
        else {
            PayPalAPI.payWithPayPal(amount);
            return true;
        }
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
