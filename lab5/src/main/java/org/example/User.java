package org.example;

public class User {
    private double PayPalBalance;
    private double StripeBalance;
    private double PrivatBankBalance;
    private double MonobankBalance;

    public User(double PayPalBalance,
                    double StripeBalance,
                    double PrivatBankBalance,
                    double MonobankBalance) {
        this.PayPalBalance = PayPalBalance;
        this.StripeBalance = StripeBalance;
        this.PrivatBankBalance = PrivatBankBalance;
        this.MonobankBalance = MonobankBalance;
    }

    public double getPayPalBalance() {
        return PayPalBalance;
    }

    public double getStripeBalance() {
        return StripeBalance;
    }

    public double getPrivatBankBalance() {
        return PrivatBankBalance;
    }

    public double getMonobankBalance() {
        return MonobankBalance;
    }
}
