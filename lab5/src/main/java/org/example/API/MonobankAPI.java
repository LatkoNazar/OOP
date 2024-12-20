package org.example.API;

import org.example.User;

public class MonobankAPI {
    User user;
    public MonobankAPI(User user) {
        this.user = user;
    }

    public double getBalance() {
        return user.getMonobankBalance();
    }

    public void transfer(double amount) {
        System.out.println("Transferred " + amount + " via Monobank.");
    }
}
