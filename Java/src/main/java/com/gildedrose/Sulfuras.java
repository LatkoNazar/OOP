package com.gildedrose;

public class Sulfuras extends Item{
    public Sulfuras(int sellIn, int quality, String name) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // This method does nothing because Sulfuras never changes quality
    }
}
