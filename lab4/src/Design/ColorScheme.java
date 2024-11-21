package Design;

import java.util.Objects;

public class ColorScheme implements Design {
    private final String color;
    public ColorScheme(String color) {
        this.color = color;
    }

    @Override
    public void describe() {
        System.out.println("Scheme color: ");
        System.out.println("---------------------");
        System.out.println(Objects.requireNonNullElse(color, "No found."));
        System.out.println("---------------------\n");
    }
}
