package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() { return sellIn; }
    public void setSellIn(int sellIn) { this.sellIn = sellIn; }
    public int getQuality() { return quality; }
    public void setQuality(int quality) { this.quality = quality; }
    public String getName() { return name; }

    public void decreaseQualityByOne() {
        if (this.quality > 0) {
            setQuality(getQuality() - 1);
        }
    }

    public void increaseQualityByOne() {
        if (this.quality < 50) {
            setQuality(getQuality() + 1);
        }
    }

    public void updateQuality() {
        decreaseQualityByOne();
        setSellIn(getSellIn() - 1);
        if (getSellIn() < 0) {
            decreaseQualityByOne();
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
