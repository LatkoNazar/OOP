package Products.ModernStyleProducts;

import Products.Furniture;

public class ModernTable implements Furniture {
    @Override
    public void describe() {
        System.out.println("Modern Table");
    }
}
