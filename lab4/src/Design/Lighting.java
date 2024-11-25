package Design;

public class Lighting implements Design{
    private final String lighting;
    private final double price;

    public Lighting(String lighting, double price) {
        this.lighting = lighting;
        this.price = price;
    }

    @Override
    public String describe() {
        return lighting + ". Price: " + price;
    }

    public double getPrice() {
        return price;
    }
}