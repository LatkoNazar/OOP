package org.example.Functions;
import org.example.Adapters.*;
import org.example.API.*;
import org.example.Item;
import org.example.Strategies.Conversion.ConversionMoney;
import org.example.Strategies.Conversion.ConversionToUAH;
import org.example.User;
import java.util.List;

public class UserInteractions {
    User user;

    MonobankAPI MonobankAPI;
    PayPalAPI PayPalAPI;
    PrivatBankAPI PrivatBankAPI;
    StripeAPI StripeAPI;

    public UserInteractions(User user) {
        this.user = user;
        MonobankAPI = new MonobankAPI(user);
        PayPalAPI = new PayPalAPI(user);
        PrivatBankAPI = new PrivatBankAPI(user);
        StripeAPI = new StripeAPI(user);
    }

    public PaymentProcessor choosePaymentProcessor() {
        PaymentProcessor processor;
        while (true) {
            System.out.println("Choose option:\n" +
                    "1 - Paypal\n" +
                    "2 - Stripe\n" +
                    "3 - Monobank\n" +
                    "4 - Privat24\n");
            int optionChoice = InputUtils.readInt("Enter a number: ");
            processor =  switch (optionChoice) {
                case 1 -> new PayPalAdapter(PayPalAPI);
                case 2 -> new StripeAdapter(StripeAPI);
                case 3 -> new MonobankAdapter(MonobankAPI);
                case 4 -> new PrivatBankAdapter(PrivatBankAPI);
                default -> null;
            };

            if (processor != null) {break;}
            System.out.println("Invalid choice!");
        }
        System.out.println();
        return processor;
    }

    public double convertCurrencyToUAH(double amount, String currency) {
        ConversionMoney converter = new ConversionToUAH(amount, currency);
        return converter.convert();
    }

    public double getTotal(List<Item> Items, PaymentProcessor processor) {
        double totalPrice = getTotalPriceForCart(Items);
        double commission = processor.calculateCommission(totalPrice);
        return totalPrice + commission;
    }

    public void showPurchase(List<Item> Items, PaymentProcessor processor) {
        double totalPrice = getTotalPriceForCart(Items);
        double commission = processor.calculateCommission(totalPrice);

        System.out.printf("Your charge for the products you want to buy: %.2f UAH%n", totalPrice);
        System.out.printf("Commission: %.2f UAH%n", commission);
        System.out.printf("Total amount: %.2f UAH%n", totalPrice + commission);
    }

    public static void PurchaseInfo(List<Item> items) {
        for (Item item : items) {
            item.describe();
        }
        System.out.println();
    }

    public double getTotalPriceForCart(List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += convertCurrencyToUAH(item.getPrice(), item.getCurrency());
        }
        return totalPrice;
    }

    public void purchase(double balance, double toPay) {
        if (balance < toPay) {
            System.out.println("You do not have enough money! Try another payment system");
            return;
        }
        System.out.println("Thank you for your purchase");
    }

    public int toPay() {
        while (true) {
            System.out.println("You want to pay?");
            int choice = InputUtils.readInt("Enter number (1 - Yes, 2 - Back, 3 - Cancel purchase): ");
            if (choice == 1) {return 1;}
            if (choice == 2) {return 2;}
            if (choice == 3) {return 3;}
            System.out.println("Invalid choice! Try again");
        }
    }
}
