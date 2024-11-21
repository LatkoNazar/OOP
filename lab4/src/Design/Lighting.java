package Design;

import java.util.Objects;

public class Lighting implements Design{
    private final String lighting;
    public Lighting(String lighting) {
        this.lighting = lighting;
    }

    @Override
    public void describe() {
        System.out.println("Lighting: ");
        System.out.println("---------------------");
        System.out.println(Objects.requireNonNullElse(lighting, "No found."));
        System.out.println("---------------------\n");
    }
}