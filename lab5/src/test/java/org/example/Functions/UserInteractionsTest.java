package org.example.Functions;

import org.example.API.MonobankAPI;
import org.example.API.PayPalAPI;
import org.example.API.PrivatBankAPI;
import org.example.API.StripeAPI;
import org.example.Adapters.MonobankAdapter;
import org.example.Adapters.PayPalAdapter;
import org.example.Adapters.PrivatBankAdapter;
import org.example.Adapters.StripeAdapter;
import org.example.Item;
import org.example.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInteractionsTest {
    List<Item> items = List.of(new Item("Milk (1 liter)", 1.20, "USD"),
            new Item("Bread (1 loaf)", 0.80, "EUR"));
    User user = new User(100, 120, 200, 10);
    @Test
    void convertCurrencyToUAHTest() {
        UserInteractions userInteractions = new UserInteractions(user);
        assertEquals(userInteractions.convertCurrencyToUAH(10, "USD"), 420, "Should be 420");
        assertEquals(userInteractions.convertCurrencyToUAH(10, "EUR"), 440, "Should be 420");
    }

    @Test
    void getTotalTest() {
        UserInteractions userInteractions = new UserInteractions(user);
        assertEquals(userInteractions.getTotal(items, new MonobankAdapter(new MonobankAPI(user))), 85.6, "Wrong actual value");
    }

    @Test
    void getTotalPriceForCartTest() {
        UserInteractions userInteractions = new UserInteractions(user);
        double priceForCart = userInteractions.getTotalPriceForCart(items);
        assertEquals(priceForCart, 85.6, "Wrong actual value");
    }
}