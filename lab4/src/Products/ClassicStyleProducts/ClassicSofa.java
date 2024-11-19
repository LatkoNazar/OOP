package Products.ClassicStyleProducts;

import Products.Furniture;

public class ClassicSofa implements Furniture {
    @Override
    public void describe() {
        System.out.println("Classic Sofa");
    }
}