package org.example.Strategies.Commission;

import org.example.Strategies.Commisssion.TieredCommissionStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TieredCommissionStrategyTest {
    TieredCommissionStrategy tieredCommission = new TieredCommissionStrategy();

    @Test
    void calculateCommission() {
        assertEquals(tieredCommission.calculateCommission(20), 0.6, "Wrong commission");
        assertEquals(tieredCommission.calculateCommission(200), 3, "Wrong commission");
        assertEquals(tieredCommission.calculateCommission(2000), 20, "Wrong commission");
    }
}
