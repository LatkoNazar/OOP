package org.example.Adapters;

import org.example.API.PayPalAPI;
import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayPalAdapterTest {
    @Test
    void testBalance() {
        User user = new User(150, 0, 0, 0);
        PayPalAPI PayPalAPI = new PayPalAPI(user);
        PayPalAdapter adapter = new PayPalAdapter(PayPalAPI);
        assertEquals(150, adapter.getBalance(), "Initial balance should be 500");
    }

    @Test
    void testProcessPayment_Successful() {
        User user = new User(500, 0, 0, 0);
        PayPalAPI payPalAPI = new PayPalAPI(user);
        PayPalAdapter adapter = new PayPalAdapter(payPalAPI);
        boolean result = adapter.processPayment(300, adapter.getBalance());
        assertTrue(result, "Payment should be successful when balance is sufficient");
    }

    @Test
    void testProcessPayment_InsufficientFunds() {
        User user = new User(0, 100, 0, 0);
        PayPalAPI payPalAPI = new PayPalAPI(user);
        PayPalAdapter adapter = new PayPalAdapter(payPalAPI);
        boolean result = adapter.processPayment(200, adapter.getBalance());
        assertFalse(result, "Payment should fail when balance is insufficient");
    }

    @Test
    void testCalculateCommission() {
        User user = new User(0, 500, 0, 0);
        PayPalAPI payPalAPI = new PayPalAPI(user);
        PayPalAdapter adapter = new PayPalAdapter(payPalAPI);
        double commission = adapter.calculateCommission(300);
        assertEquals(6, commission, "Commission for PayPal should be 2%");
    }
}
