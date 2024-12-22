package org.example.Adapters;

import org.example.API.PrivatBankAPI;
import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivatBankAdapterTest {
    @Test
    void testBalance() {
        User user = new User(0, 0, 10, 0);
        PrivatBankAPI privatBankAPI = new PrivatBankAPI(user);
        PrivatBankAdapter adapter = new PrivatBankAdapter(privatBankAPI);
        assertEquals(10, adapter.getBalance(), "Initial balance should be 500");
    }

    @Test
    void testProcessPayment_Successful() {
        User user = new User(0, 0, 500, 0);
        PrivatBankAPI privatBankAPI = new PrivatBankAPI(user);
        PrivatBankAdapter adapter = new PrivatBankAdapter(privatBankAPI);
        boolean result = adapter.processPayment(300, adapter.getBalance());
        assertTrue(result, "Payment should be successful when balance is sufficient");
    }

    @Test
    void testProcessPayment_InsufficientFunds() {
        User user = new User(0, 0, 100, 0);
        PrivatBankAPI privatBankAPI = new PrivatBankAPI(user);
        PrivatBankAdapter adapter = new PrivatBankAdapter(privatBankAPI);
        boolean result = adapter.processPayment(200, adapter.getBalance());
        assertFalse(result, "Payment should fail when balance is insufficient");
    }

    @Test
    void testCalculateCommission() {
        User user = new User(0, 0, 500, 0);
        PrivatBankAPI privatBankAPI = new PrivatBankAPI(user);
        PrivatBankAdapter adapter = new PrivatBankAdapter(privatBankAPI);
        double commission = adapter.calculateCommission(300);
        assertEquals(0.015 * 300, commission, "Commission should be calculated properly");
    }
}
