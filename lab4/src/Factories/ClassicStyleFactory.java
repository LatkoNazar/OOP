package Factories;

import Products.FurnitureData;
import java.util.List;
import Products.ClassicStyleProducts.ClassicChair;
import Products.ClassicStyleProducts.ClassicSofa;
import Products.ClassicStyleProducts.ClassicTable;
import Products.Furniture;

public class ClassicStyleFactory implements StyleFactory{
    public List<FurnitureData> ChairList = List.of(
            new FurnitureData("Minerva chair", 150),
            new FurnitureData("Solid Wood Dining Chair Retro", 130),
            new FurnitureData("Marco Chair", 125.50),
            new FurnitureData("Default classic chair", 100)
    );

    public List<FurnitureData> SofaList = List.of(
            new FurnitureData("Classic violet sofa", 180),
            new FurnitureData("Ralles Classic Sofa", 165.00),
            new FurnitureData("Luxury Classic Sofa", 300),
            new FurnitureData("Default classic sofa", 120)
    );

    public List<FurnitureData> TableList = List.of(
            new FurnitureData("Classic wooden table", 160),
            new FurnitureData("Rectangular wooden table", 140.33),
            new FurnitureData("Classic Game Table", 110),
            new FurnitureData("Default classic table", 130)
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
        return new ClassicChair(name, price);
    }

    @Override
    public Furniture CreateSofa(String name, double price) {
        return new ClassicSofa(name, price);
    }

    @Override
    public Furniture CreateTable(String name, double price) {
        return new ClassicTable(name, price);
    }
}
