package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.getName().equals("Aged Brie")
                || item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getQuality() < 50) {
                        item.increaseQualityByOne();

                        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.getQuality() < 11) {
                                item.increaseQualityByOne();
                            }

                            if (item.getQuality() < 6) {
                                item.increaseQualityByOne();
                            }
                        }
                    }
                } else {
                if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    item.decreaseQualityByOne();
                }
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (item.getName().equals("Aged Brie")) {
                    item.increaseQualityByOne();
                } else {
                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.setQuality(0);
                    } else {
                        if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                            item.decreaseQualityByOne();
                        }
                    }
                }
            }
        }
    }
}
