package org.example.Adapters;

import org.example.API.MonobankAPI;
import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonobankAdapterTest {
    @Test
    void testBalance() {
        User user = new User(0, 0, 0, 10);
        MonobankAPI monobankAPI = new MonobankAPI(user);
        MonobankAdapter adapter = new MonobankAdapter(monobankAPI);
        assertEquals(10.0, adapter.getBalance(), "Initial balance should be 500");
    }

    @Test
    void testProcessPayment_Successful() {
        User user = new User(0, 0, 0, 500);
        MonobankAPI monobankAPI = new MonobankAPI(user);
        MonobankAdapter adapter = new MonobankAdapter(monobankAPI);
        boolean result = adapter.processPayment(300, adapter.getBalance());
        assertTrue(result, "Payment should be successful when balance is sufficient");
    }

    @Test
    void testProcessPayment_InsufficientFunds() {
        User user = new User(100, 0, 0, 0);
        MonobankAPI monobankAPI = new MonobankAPI(user);
        MonobankAdapter adapter = new MonobankAdapter(monobankAPI);
        boolean result = adapter.processPayment(200, adapter.getBalance());
        assertFalse(result, "Payment should fail when balance is insufficient");
    }

    @Test
    void testCalculateCommission() {
        User user = new User(500, 0, 0, 0);
        MonobankAPI monobankAPI = new MonobankAPI(user);
        MonobankAdapter adapter = new MonobankAdapter(monobankAPI);
        double commission = adapter.calculateCommission(300);
        assertEquals(0, commission, "Commission for Monobank should be 0");
    }
}
