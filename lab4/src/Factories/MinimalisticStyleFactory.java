package Factories;

import Products.ClassicStyleProducts.ClassicSofa;
import Products.MinimalisticStyleProducts.MinimalisticChair;
import Products.MinimalisticStyleProducts.MinimalisticSofa;
import Products.Furniture;
import Products.MinimalisticStyleProducts.MinimalisticChair;
import Products.MinimalisticStyleProducts.MinimalisticTable;

public class MinimalisticStyleFactory implements StyleFactory{
    @Override
    public Furniture CreateChair() {
        return new MinimalisticChair();
    }

    @Override
    public Furniture CreateSofa() {
        return new MinimalisticSofa();
    }

    @Override
    public Furniture CreateTable() {
        return new MinimalisticTable();
    }
}
