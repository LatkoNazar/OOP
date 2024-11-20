package Design;

public class FurnitureLayout implements Design {
    private String layout;
    public FurnitureLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public String getData() {
        return layout;
    }
}