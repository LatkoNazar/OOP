package org.example.API;

import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StripeAPITest {
    @Test
    void StripeAPIgetBalance() {
        User user = new User(0, 10, 0, 0);
        StripeAPI StripeAPI = new StripeAPI(user);
        assertEquals(StripeAPI.getBalance(), 10, "Should return 10");
    }
}