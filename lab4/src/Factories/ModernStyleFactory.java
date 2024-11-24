package Factories;

import Products.Furniture;
import Products.FurnitureData;
import Products.ModernStyleProducts.ModernChair;
import Products.ModernStyleProducts.ModernSofa;
import Products.ModernStyleProducts.ModernTable;
import java.util.List;

public class ModernStyleFactory implements StyleFactory{
    private final List<FurnitureData> ChairList = List.of(
            new FurnitureData("Modern Chair Smooth", 70),
            new FurnitureData("Modern chair PRO", 122),
            new FurnitureData("Gaming Chair", 124.44),
            new FurnitureData("Default modern chair", 80)
    );

    private final List<FurnitureData> SofaList = List.of(
            new FurnitureData("Modern black sofa", 122),
            new FurnitureData("4 Seater Sofa", 144.50),
            new FurnitureData("Comfort Sofa", 190),
            new FurnitureData("Default modern sofa", 110)
    );

    private final List<FurnitureData> TableList = List.of(
            new FurnitureData("Modern Blue Table", 150),
            new FurnitureData("Gaming & Study Table", 133.33),
            new FurnitureData("Modern white table", 114),
            new FurnitureData("Default modern table", 120)
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
        return new ModernChair(name, price);
    }

    @Override
    public Furniture CreateSofa(String name, double price) {
        return new ModernSofa(name, price);
    }

    @Override
    public Furniture CreateTable(String name, double price) {
        return new ModernTable(name, price);
    }
}
