package Services;

import java.util.ArrayList;
import java.util.List;
import Design.Design;
import Design.Lighting;
import Design.ColorScheme;
import Design.FurnitureLayout;
import Factories.StyleFactory;
import Products.Furniture;
import Utils.UserInteractions;

public class InteriorDesigner {
    private final StyleFactory styleFactory;
    private final List<Furniture> FurnitureList = new ArrayList<>();
    private Lighting lighting;
    private ColorScheme colorScheme;
    private FurnitureLayout furnitureLayout;

    UserInteractions userInteractions = new UserInteractions();

    public InteriorDesigner(StyleFactory styleFactory) {
        this.styleFactory = styleFactory;
    }

    public void addFurniture() {
        String furnitureType = userInteractions.chooseTypeFurniture();
        Furniture furniture = userInteractions.chooseFurniture(furnitureType, styleFactory);
        FurnitureList.add(furniture);
    }

    public void addColorScheme() {
        this.colorScheme = userInteractions.chooseColorScheme();
    }

    public void addFurnitureLayout() {
        this.furnitureLayout = userInteractions.chooseFurnitureLayout();
    }

    public void addLighting() {
        this.lighting = userInteractions.chooseLighting();
    }

    public void describeFurnitureList() {
        System.out.println("Furniture list:");
        System.out.println("---------------------");
        if (FurnitureList.isEmpty()){
            System.out.println("No furniture found. please add new!!!");
        }
        else {
            for (Furniture furniture : FurnitureList) {
                furniture.describe();
            }
        }
        System.out.println("---------------------\n");
    }

    public void describeDesign(Design feature, String message) {
        System.out.println(message + ": ");
        System.out.println("---------------------");
        if (feature == null) {
            System.out.println("No found. Should add!!!");
        } else {
            System.out.println(feature.describe());
        }
        System.out.println("---------------------\n");
    }

    public void describeInterior() {
        describeFurnitureList();
        describeDesign(lighting, "Lightning");
        describeDesign(colorScheme, "ColorScheme");
        describeDesign(furnitureLayout, "Furniture layout");
    }
}