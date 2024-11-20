package Design;

public class Lighting implements Design{
    private String lighting;
    public Lighting(String lighting) {
        this.lighting = lighting;
    }

    @Override
    public String getData() {
        return lighting;
    }
}