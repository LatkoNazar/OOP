package Design;

import java.util.Objects;

public class FurnitureLayout implements Design {
    private final String layout;
    public FurnitureLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public String describe() {
        return layout;
    }
}