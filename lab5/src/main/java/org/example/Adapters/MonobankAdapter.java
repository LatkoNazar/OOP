package org.example.Adapters;
import org.example.API.MonobankAPI;
import org.example.Strategies.Commisssion.NoCommission;

public class MonobankAdapter implements PaymentProcessor {
    private MonobankAPI MonobankAPI;
    NoCommission noCommission = new NoCommission();

    public MonobankAdapter(MonobankAPI MonobankAPI) {
        this.MonobankAPI = MonobankAPI;
    }

    @Override
    public void processPayment(double amount) {
        MonobankAPI.transfer(amount);
    }

    @Override
    public double calculateCommission(double amount) {
        return noCommission.calculateCommission(amount);
    }

    @Override
    public double getBalance() {
        return MonobankAPI.getBalance();
    }
}