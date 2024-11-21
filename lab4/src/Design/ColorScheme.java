package Design;

import java.util.Objects;

public class ColorScheme implements Design {
    private final String color;
    public ColorScheme(String color) {
        this.color = color;
    }

    @Override
    public String describe() {
        return color;
    }
}
