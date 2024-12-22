package org.example.API;

import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PayPalAPITest {
    @Test
    void PayPalAPIgetBalance() {
        User user = new User(7, 0, 0, 0);
        PayPalAPI PayPalAPI = new PayPalAPI(user);
        assertEquals(PayPalAPI.getBalance(), 7, "Should return 7");
    }
}