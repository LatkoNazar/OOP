package Design;

public class ColorScheme implements Design {
    private String color;
    public ColorScheme(String color) {
        this.color = color;
    }

    @Override
    public String getData() {
        return color;
    }
}
