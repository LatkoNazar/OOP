package Products;

public class AbstractFurniture implements Furniture {
    private final String name;
    private final double price;

    public AbstractFurniture(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void describe() {
        System.out.println("Name: " + name + ". Price: " + price);
    }
}
