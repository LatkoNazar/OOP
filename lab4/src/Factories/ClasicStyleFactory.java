package Factories;

import Products.ClassicStyleProducts.ClassicChair;
import Products.ClassicStyleProducts.ClassicSofa;
import Products.Furniture;

public class ClasicStyleFactory implements StyleFactory{
    @Override
    public Furniture CreateChair() {
        return new ClassicChair();
    }

    @Override
    public Furniture CreateSofa() {
        return new ClassicSofa();
    }
}