import Design.ColorScheme;
import Design.FurnitureLayout;
import Design.Lighting;
import Factories.ClasicStyleFactory;
import Factories.MinimalisticStyleFactory;
import Factories.ModernStyleFactory;
import Factories.StyleFactory;
import Services.InteriorDesigner;
import Utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        InteriorDesigner designer;
        while (true) {
            System.out.println("Choose style (1 - Modern, 2 - Classic, 3 - Minimalistic.):");
            int styleChoice = InputUtils.readInt("Enter a number: ");
            StyleFactory factory = switch (styleChoice) {
                case 1 -> new ModernStyleFactory();
                case 2 -> new ClasicStyleFactory();
                case 3 -> new MinimalisticStyleFactory();
                default -> null;
            };

            if (factory != null) {
                designer = new InteriorDesigner(factory);
                break;
            }
            System.out.println("Invalid choice!");
        }


        while(true) {
            System.out.println("Choose option (1 - Add furniture, 2 - Choose color scheme, 3 - Choose furniture layout, 4 - Choose lightning, 5 - Show interior, 6 - Exit):");
            int optionChoice = InputUtils.readInt("Enter a number: ");
            switch (optionChoice) {
                case 1 -> designer.addFurniture();
                case 2 -> {
                    String color = InputUtils.readString("Enter a color: ");
                    ColorScheme colorScheme = new ColorScheme(color);
                    designer.addColorScheme(colorScheme);
                }
                case 3 -> {
                    String layout = InputUtils.readString("Enter a desired furniture layout: ");
                    FurnitureLayout furnitureLayout = new FurnitureLayout(layout);
                    designer.addFurnitureLayout(furnitureLayout);
                }
                case 4 -> {
                    String light = InputUtils.readString("Enter a desired lighting: ");
                    Lighting lighting = new Lighting(light);
                    designer.addLighting(lighting);
                }
                case 5 -> designer.describeInterior();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}