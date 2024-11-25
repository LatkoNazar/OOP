package Design;

public class ColorScheme implements Design {
    private final String color;
    private final double price;

    public ColorScheme(String color, double price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String describe() {
        return color + ". Price: " + price;
    }

    public double getPrice() {
        return price;
    }
}
