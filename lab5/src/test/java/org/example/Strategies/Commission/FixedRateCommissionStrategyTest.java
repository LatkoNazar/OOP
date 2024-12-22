package org.example.Strategies.Commission;

import org.example.Strategies.Commisssion.FixedRateCommissionStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedRateCommissionStrategyTest {
    @Test
    void calculateCommission() {
        FixedRateCommissionStrategy strategy = new FixedRateCommissionStrategy(0.2);
        double com = strategy.calculateCommission(100);
        assertEquals(com, 20, "Wrong commission");
    }
}
