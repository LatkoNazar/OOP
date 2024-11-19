package Factories;

import Products.Furniture;
import Products.ModernStyleProducts.ModernChair;
import Products.ModernStyleProducts.ModernSofa;

public class ModernStyleFactory implements StyleFactory{
    @Override
    public Furniture CreateChair() {
        return new ModernChair();
    }

    @Override
    public Furniture CreateSofa() {
        return new ModernSofa();
    }
}