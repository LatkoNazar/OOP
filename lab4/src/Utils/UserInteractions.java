package Utils;

import Design.ColorScheme;
import Design.FurnitureLayout;
import Design.Lighting;
import Factories.ClassicStyleFactory;
import Factories.MinimalisticStyleFactory;
import Factories.ModernStyleFactory;
import Products.Furniture;
import Products.FurnitureData;
import Services.InteriorDesigner;
import Factories.StyleFactory;
import java.util.List;

public class UserInteractions {
    public int chooseOption() {
        System.out.println("Choose option:\n" +
                "1 - Add furniture\n" +
                "2 - Choose color scheme\n" +
                "3 - Choose furniture layout\n" +
                "4 - Choose lightning\n" +
                "5 - Show interior\n" +
                "6 - Exit):");
        int optionChoice = InputUtils.readInt("Enter a number: ");
        System.out.println();
        return optionChoice;
    }

    public InteriorDesigner chooseDesigner() {
        InteriorDesigner designer;
        while (true) {
            System.out.println("Choose style:\n" +
                    "1 - Modern\n" +
                    "2 - Classic\n" +
                    "3 - Minimalistic");
            int styleChoice = InputUtils.readInt("Enter a number: ");
            StyleFactory factory = switch (styleChoice) {
                case 1 -> new ModernStyleFactory();
                case 2 -> new ClassicStyleFactory();
                case 3 -> new MinimalisticStyleFactory();
                default -> null;
            };

            if (factory != null) {
                designer = new InteriorDesigner(factory);
                break;
            }
            System.out.println("Invalid choice!");
        }
        System.out.println();
        return designer;
    }


    public String chooseTypeFurniture() {
        String furnitureType;
        while (true) {
            System.out.println("Choose a furniture:\n" +
                    "1 - Chair\n" +
                    "2 - Sofa\n" +
                    "3 - Table");
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
        System.out.println();
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
                System.out.println(index + ") " + furnitureData.getName() + ". Price: " + furnitureData.getPrice());
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
        System.out.println();
        return furniture;
    }

    public Lighting chooseLighting() {
        Lighting lighting = null;
        while (true) {
            System.out.println("Choose lighting:\n" +
                    "1 - General\n" +
                    "2 - Ambient\n" +
                    "3 - Mood\n" +
                    "4 - Task\n" +
                    "5 - Accent");
            int choice = InputUtils.readInt("Enter a number: ");
            if (choice >=1 && choice <=5) {
                switch (choice) {
                    case 1 -> lighting = new Lighting("General", 40);
                    case 2 -> lighting = new Lighting("Ambient", 60);
                    case 3 -> lighting = new Lighting("Mood", 75);
                    case 4 -> lighting = new Lighting("Task", 50);
                    case 5 -> lighting = new Lighting("Accent", 80);
                }
                break;
            }
            System.out.println("Invalid choice!");
        }
        System.out.println();
        return lighting;
    }

    public ColorScheme chooseColorScheme() {
        ColorScheme colorScheme = null;
        while (true) {
            System.out.println("Choose color scheme:\n" +
                    "1 - Monochrome - Black, White, Gray\n" +
                    "2 - Earth Tones - Brown, Beige, Olive Green, Terracotta\n" +
                    "3 - Bright Contrast - Red, Yellow, Blue, White\n" +
                    "4 - Pastel Palette - Baby Pink, Mint Green, Lavender, Soft Peach\n" +
                    "5 - Neutral Warmth - Cream, Taupe, Light Gray, Soft Gold");
            int choice = InputUtils.readInt("Enter a number: ");
            if (choice >=1 && choice <=5) {
                switch (choice) {
                    case 1 -> colorScheme = new ColorScheme("Monochrome - Black, White, Gray", 40);
                    case 2 -> colorScheme = new ColorScheme("Earth Tones - Brown, Beige, Olive Green, Terracotta", 60);
                    case 3 -> colorScheme = new ColorScheme("Bright Contrast - Red, Yellow, Blue, White", 75);
                    case 4 -> colorScheme = new ColorScheme("Pastel Palette - Baby Pink, Mint Green, Lavender, Soft Peach", 50);
                    case 5 -> colorScheme = new ColorScheme("Neutral Warmth - Cream, Taupe, Light Gray, Soft Gold", 80);
                }
                break;
            }
            System.out.println("Invalid choice!");
        }
        System.out.println();
        return colorScheme;
    }

    public FurnitureLayout chooseFurnitureLayout() {
        FurnitureLayout furnitureLayout = null;
        while (true) {
            System.out.println("Choose color scheme:\n" +
                    "1 - Open Plan - Furniture arranged to maximize space and flow without dividing walls\n" +
                    "2 - Symmetrical Layout - Balanced placement with identical items on either side\n" +
                    "3 - Zoned Layout - Dividing the room into functional areas like lounging, dining, and workspace\n" +
                    "4 - Minimalist Layout - Simple arrangement with only essential furniture for a clean and airy feel\n" +
                    "5 - Clustered Layout - Furniture grouped together for conversation or activity");
            int choice = InputUtils.readInt("Enter a number: ");
            if (choice >=1 && choice <=5) {
                switch (choice) {
                    case 1 -> furnitureLayout = new FurnitureLayout("Open Plan - Furniture arranged to maximize space and flow without dividing walls");
                    case 2 -> furnitureLayout = new FurnitureLayout("Symmetrical Layout - Balanced placement with identical items on either side");
                    case 3 -> furnitureLayout = new FurnitureLayout("Zoned Layout - Dividing the room into functional areas like lounging, dining, and workspace");
                    case 4 -> furnitureLayout = new FurnitureLayout("Minimalist Layout - Simple arrangement with only essential furniture for a clean and airy feel");
                    case 5 -> furnitureLayout = new FurnitureLayout("Clustered Layout - Furniture grouped together for conversation or activity");
                }
                break;
            }
            System.out.println("Invalid choice!");
        }
        System.out.println();
        return furnitureLayout;
    }
}
