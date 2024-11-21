package Design;

import java.util.Objects;

public class FurnitureLayout implements Design {
    private final String layout;
    public FurnitureLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public void describe() {
        System.out.println("Furniture layout: ");
        System.out.println("---------------------");
        System.out.println(Objects.requireNonNullElse(layout, "No found."));
        System.out.println("---------------------\n");
    }
}