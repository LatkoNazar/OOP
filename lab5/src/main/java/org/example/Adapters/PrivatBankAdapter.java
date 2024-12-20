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
    public boolean processPayment(double amount, double balance) {
        if (balance < amount) {
            System.out.println("You do not have enough money!");
            return false;
        }
        else {
            PrivatBankAPI.transfer(amount);
            return true;
        }
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
