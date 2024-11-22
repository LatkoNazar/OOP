package Factories;

import Products.ClassicStyleProducts.ClassicSofa;
import Products.FurnitureData;
import Products.MinimalisticStyleProducts.MinimalisticChair;
import Products.MinimalisticStyleProducts.MinimalisticSofa;
import Products.Furniture;
import Products.MinimalisticStyleProducts.MinimalisticChair;
import Products.MinimalisticStyleProducts.MinimalisticTable;

import java.util.List;

public class MinimalisticStyleFactory implements StyleFactory{
    public List<FurnitureData> ChairList = List.of(
            new FurnitureData("Chair Smooth", 90),
            new FurnitureData("Minimalistic chair Gropius", 120),
            new FurnitureData("Remarkable Minimal Chair", 124.50),
            new FurnitureData("Default minimalistic chair", 90)
    );

    public List<FurnitureData> SofaList = List.of(
            new FurnitureData("Minimalistic black sofa", 145),
            new FurnitureData("Three Seater Sofa", 142.50),
            new FurnitureData("Compact Sofa", 170),
            new FurnitureData("Default minimalistic sofa", 120)
    );

    public List<FurnitureData> TableList = List.of(
            new FurnitureData("Minimalist Coffee Table", 160),
            new FurnitureData("Invisible Bed Minimalist Study Table", 140.33),
            new FurnitureData("Minimalistic gaming table", 110),
            new FurnitureData("Default minimalistic table", 130)
    );

    public List<FurnitureData> getChairList() {
        return ChairList;
    }

    public List<FurnitureData> getSofaList() {
        return SofaList;
    }

    public List<FurnitureData> getTableList() {
        return TableList;
    }

    @Override
    public Furniture CreateChair(String name, double price) {
        return new MinimalisticChair(name, price);
    }

    @Override
    public Furniture CreateSofa(String name, double price) {
        return new MinimalisticSofa(name, price);
    }

    @Override
    public Furniture CreateTable(String name, double price) {
        return new MinimalisticTable(name, price);
    }
}
