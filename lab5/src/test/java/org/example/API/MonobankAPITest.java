package org.example.API;

import org.example.API.MonobankAPI;
import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonobankAPITest {
    @Test
    void MonobankAPIgetBalance() {
        User user = new User(0, 0, 0, 500);
        MonobankAPI monobankAPI = new MonobankAPI(user);
        assertEquals(monobankAPI.getBalance(), 500, "Should return 500");
    }
}
