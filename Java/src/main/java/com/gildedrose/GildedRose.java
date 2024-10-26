package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()){
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.increaseQualityByOne();
                    if (item.getQuality() < 11) {
                        item.increaseQualityByOne();
                    }
                    if (item.getQuality() < 6) {
                        item.increaseQualityByOne();
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    }
                    break;
                default:
                    item.updateQuality();
                    break;
            }
        }
    }
}
