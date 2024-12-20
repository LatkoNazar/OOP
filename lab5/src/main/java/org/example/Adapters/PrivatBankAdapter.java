package org.example.Adapters;
import org.example.API.PrivatBankAPI;
import org.example.Strategies.Commisssion.TieredCommissionStrategy;

public class PrivatBankAdapter implements PaymentProcessor {
    private PrivatBankAPI PrivatBankAPI;
    TieredCommissionStrategy tieredCommissionStrategy = new TieredCommissionStrategy();

    public PrivatBankAdapter(PrivatBankAPI PrivatBankAPI) {
        this.PrivatBankAPI = PrivatBankAPI;
    }

    @Override
    public void processPayment(double amount) {
        PrivatBankAPI.transfer(amount);
    }

    @Override
    public double calculateCommission(double amount) {
        return tieredCommissionStrategy.calculateCommission(amount);
    }

    @Override
    public double getBalance() {
        return PrivatBankAPI.getBalance();
    }
}
