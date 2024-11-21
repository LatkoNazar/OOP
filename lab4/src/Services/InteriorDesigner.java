package Services;

import java.util.ArrayList;
import java.util.List;

import Design.Lighting;
import Design.ColorScheme;
import Design.FurnitureLayout;
import Factories.StyleFactory;
import Products.Furniture;
import Utils.InputUtils;

public class InteriorDesigner {
    private final StyleFactory styleFactory;
    private final List<Furniture> FurnitureList = new ArrayList<>();
    private Lighting lighting;
    private ColorScheme colorScheme;
    private FurnitureLayout furnitureLayout;


    public InteriorDesigner(StyleFactory styleFactory) {
        this.styleFactory = styleFactory;
    }

    public void addFurniture() {
        Furniture furniture = chooseFurniture();
        FurnitureList.add(furniture);
    }

    public void addColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    public void addFurnitureLayout(FurnitureLayout furnitureLayout) {
        this.furnitureLayout = furnitureLayout;
    }

    public void addLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    public Furniture chooseFurniture() {
        Furniture furniture;
        while (true) {
            System.out.println("Choose a furniture (1 - Chair, 2 - Sofa, 3 - Table): ");
            int styleChoice = InputUtils.readInt("Enter a number: ");
            furniture = switch (styleChoice) {
                case 1 -> styleFactory.CreateChair();
                case 2 -> styleFactory.CreateSofa();
                case 3 -> styleFactory.CreateTable();
                default -> null;
            };
            if (furniture != null) {break;}
            System.out.println("Invalid choice!");
        }
        return furniture;
    }

    public void describeFurnitureList() {
        System.out.println("Furniture list:");
        System.out.println("---------------------");
        if (FurnitureList.isEmpty()){
            System.out.println("No furniture found.");
        }
        else {
            for (Furniture furniture : FurnitureList) {
                furniture.describe();
            }
        }
        System.out.println("---------------------\n");
    }


    public void describeInterior() {
        describeFurnitureList();
        lighting.describe();
        colorScheme.describe();
        furnitureLayout.describe();
    }
}