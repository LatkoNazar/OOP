package org.example.Strategies.Conversion;

public class ConversionToUAH implements ConversionMoney{
    private double amount;
    private String currency;

    public ConversionToUAH(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double convertUSD_UAH(double amountUSD) {
        return amountUSD * 42;
    }

    public double convertEUR_UAH(double amountEUR) {
        return amountEUR * 44;
    }

    @Override
    public double convert() {
        if (currency.equals("EUR")) {
            return convertEUR_UAH(amount);
        }
        return convertUSD_UAH(amount);
    }
}
