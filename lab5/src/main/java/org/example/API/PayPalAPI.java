package org.example.API;
import org.example.User;

public class PayPalAPI {
    User user;
    public PayPalAPI(User user) {
        this.user = user;
    }

    public double getBalance() {
        return user.getPayPalBalance();
    }

    public void payWithPayPal(double amount) {
        System.out.printf("Paid %.2fUAH via PayPal.\n", amount);
    }
}