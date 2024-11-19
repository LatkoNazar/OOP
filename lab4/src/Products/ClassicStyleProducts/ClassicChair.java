package Products.ClassicStyleProducts;

import Products.Furniture;

public class ClassicChair implements Furniture {
    @Override
    public void describe() {
        System.out.println("Classic Chair");
    }
}
