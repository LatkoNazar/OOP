package Design;

import java.util.Objects;

public class Lighting implements Design{
    private final String lighting;
    public Lighting(String lighting) {
        this.lighting = lighting;
    }

    @Override
    public String describe() {
        return lighting;
    }
}