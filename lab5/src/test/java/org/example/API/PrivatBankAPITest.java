package org.example.API;

import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PrivatBankAPITest {
    @Test
    void PrivatBankAPIgetBalance() {
        User user = new User(0, 0, 10, 0);
        PrivatBankAPI PrivatBankAPI = new PrivatBankAPI(user);
        assertEquals(PrivatBankAPI.getBalance(), 10, "Should return 10");
    }
}