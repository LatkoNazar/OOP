package org.example;

import org.example.Adapters.*;
import org.example.Functions.*;

import java.io.FileNotFoundException;
import java.util.List;

public class App {
    final static List<Item> Cart= List.of(new Item("Milk (1 liter)", 1.20, "USD"),
            new Item("Bread (1 loaf)", 0.80, "EUR"),
            new Item("Eggs (12-pack)", 5, "USD"),
            new Item("Butter (200 g)", 1.90, "EUR"),
            new Item("Cheese (1 kg)", 6.00, "USD"),
            new Item("Chicken Breast (1 kg)", 7.50, "USD"),
            new Item("Rice (1 kg)", 2.00, "EUR"),
            new Item("Pasta (500 g)", 1.20, "USD"),
            new Item("Apples (1 kg)", 2.00, "USD"),
            new Item("Bananas (1 kg)", 1.50, "EUR"));


    public static void main(String[] args) throws FileNotFoundException {
        User user = new User(150, 270, 300, 2);
        UserInteractions ui = new UserInteractions(user);
        UserInteractions.PurchaseInfo(Cart);

        while (true) {
            PaymentProcessor processor = ui.choosePaymentProcessor();
            ui.showPurchase(Cart, processor);
            double balance = ui.convertCurrencyToUAH(processor.getBalance(), "USD");
            System.out.println();
            System.out.println("Your balance: " + balance + " UAH");
            System.out.println();
            int toPay = ui.toPay();
            switch (toPay) {
                case 1: {
                    boolean success = processor.processPayment(ui.getTotal(Cart, processor), balance);
                    if (success) {
                        PDFCreator pdf = new PDFCreator("Hello world, Nazar");
                        pdf.createPDF(Cart);
                        System.exit(0);
                    }
                    else break;
                }
                case 2: {
                    System.out.println("<-");
                    break;
                }
                case 3: {
                    System.out.println("Your purchase was canceled. Goodbye.");
                    System.exit(0);
                }
                default: System.exit(0);
            }
        }
    }
}