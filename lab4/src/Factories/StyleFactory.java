package Factories;

import Products.Furniture;
import Products.FurnitureData;
import java.util.List;

public interface StyleFactory {
    Furniture CreateChair(String name, double price);
    Furniture CreateSofa(String name, double price);
    Furniture CreateTable(String name, double price);
    List<FurnitureData> getChairList();
    List<FurnitureData> getSofaList();
    List<FurnitureData> getTableList();
}
