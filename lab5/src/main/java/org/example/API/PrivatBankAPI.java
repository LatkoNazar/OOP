package org.example.API;

import org.example.User;

public class PrivatBankAPI {
    User user;
    public PrivatBankAPI(User user) {
        this.user = user;
    }

    public double getBalance() {
        return user.getPrivatBankBalance();
    }

    public void transfer(double amount) {
        System.out.println("Transferred " + amount + " via PrivatBank.");
    }
}