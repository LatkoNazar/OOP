package Factories;

import Products.Furniture;

public interface StyleFactory {
    Furniture CreateChair();
    Furniture CreateSofa();
}
