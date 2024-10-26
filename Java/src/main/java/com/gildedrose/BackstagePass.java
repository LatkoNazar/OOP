package com.gildedrose;

public class BackstagePass extends Item {

    public BackstagePass(String name, int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality(){
        increaseQualityByOne();
        if (getQuality() < 11) {
            increaseQualityByOne();
        }
        if (getQuality() < 6) {
            increaseQualityByOne();
        }
        setSellIn(getSellIn() - 1);
        if (getSellIn() < 0) {
            setQuality(0);
        }
    }
}
