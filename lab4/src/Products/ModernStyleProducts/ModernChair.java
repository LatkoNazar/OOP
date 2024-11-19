package Products.ModernStyleProducts;

import Products.Furniture;

public class ModernChair implements Furniture {
    @Override
    public void describe() {
        System.out.println("Modern Chair");
    }
}