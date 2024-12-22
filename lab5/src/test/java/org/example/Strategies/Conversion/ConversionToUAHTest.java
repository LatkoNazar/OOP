package org.example.Strategies.Conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionToUAHTest {
    ConversionToUAH conversionToUAHone = new ConversionToUAH(10, "USD");
    ConversionToUAH conversionToUAHtwo = new ConversionToUAH(10, "EUR");


    @Test
    void conversionUSD_UAH_test() {
        assertEquals(conversionToUAHone.convertUSD_UAH(10), 420, "Wrong value");
        assertEquals(conversionToUAHtwo.convertEUR_UAH(10), 440, "Wrong value");
    }

    @Test
    void convertTest() {
        assertEquals(conversionToUAHone.convert(), 420, "Wrong value");
        assertEquals(conversionToUAHtwo.convert(), 440, "Wrong value");
    }
}
