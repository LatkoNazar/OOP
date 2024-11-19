package Design;

public class ColorScheme {
    private String color;
    public ColorScheme(String color) {
        this.color = color;
    }

    public void applyColorScheme() {
        System.out.println("Applying color scheme: " + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
