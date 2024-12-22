package org.example.Strategies.Commission;
import org.example.Strategies.Commisssion.NoCommission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class NoCommissionTest {
    NoCommission noCommission = new NoCommission();

    @Test
    public void testNoCommission() {
        assertEquals(noCommission.calculateCommission(100), 0, "Wrong commission");
    }
}
