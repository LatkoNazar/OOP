package Products.ClassicStyleProducts;

import Products.Furniture;

public class ClassicTable implements Furniture {
    @Override
    public void describe() {
        System.out.println("Classic Table");
    }
}