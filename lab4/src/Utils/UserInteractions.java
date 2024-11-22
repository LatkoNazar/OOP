package Utils;
import Products.Furniture;
import Products.FurnitureData;
import Utils.InputUtils;
import Factories.StyleFactory;

import java.util.List;

public class UserInteractions {
    public String chooseTypeFurniture() {
        String furnitureType;
        while (true) {
            System.out.println("Choose a furniture (1 - Chair, 2 - Sofa, 3 - Table): ");
            int styleChoice = InputUtils.readInt("Enter a number: ");
            furnitureType = switch (styleChoice) {
                case 1 -> "Chair";
                case 2 -> "Sofa";
                case 3 -> "Table";
                default -> null;
            };
            if (furnitureType != null) {break;}
            System.out.println("Invalid choice!");
        }
        return furnitureType;
    }

    public Furniture chooseFurniture(String furnitureType, StyleFactory styleFactory) {
        Furniture furniture = null;
        List<FurnitureData> furnitureList = switch (furnitureType) {
            case "Chair" -> styleFactory.getChairList();
            case "Sofa" -> styleFactory.getSofaList();
            case "Table" -> styleFactory.getTableList();
            default -> null;
        };
        while (true) {
            System.out.println("Choose a furniture: ");
            int index = 1;
            for (FurnitureData furnitureData : furnitureList) {
                System.out.println("Name: " + furnitureData.getName() + ". Price: " + furnitureData.getPrice());
                index++;
            }
            int furnitureChoice = InputUtils.readInt("Enter a number: ");
            if (furnitureChoice >= 1 && furnitureChoice <= furnitureList.size()) {
                String name = furnitureList.get(furnitureChoice - 1).getName();
                double price = furnitureList.get(furnitureChoice - 1).getPrice();
                switch (furnitureType) {
                    case "Chair" -> furniture = styleFactory.CreateChair(name, price);
                    case "Sofa" -> furniture = styleFactory.CreateSofa(name, price);
                    case "Table" -> furniture = styleFactory.CreateTable(name, price);
                }
                break;
            }
            System.out.println("Invalid choice!");
        }
        return furniture;
    }
}
