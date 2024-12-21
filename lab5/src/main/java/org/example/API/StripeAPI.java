package org.example.API;

import org.example.User;

public class StripeAPI {
    User user;
    public StripeAPI(User user) {
        this.user = user;
    }

    public double getBalance() {
        return user.getStripeBalance();
    }

    public void makeStripePayment(double amount) {
        System.out.printf("Paid %.2fUAH via Stripe.\n", amount);
    }
}
