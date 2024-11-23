import Services.InteriorDesigner;
import Utils.UserInteractions;

public class App {
    public static void main(String[] args) {
        UserInteractions ui = new UserInteractions();
        InteriorDesigner designer = ui.chooseDesigner();
        while(true) {
            int optionChoice = ui.chooseOption();
            switch (optionChoice) {
                case 1 -> designer.addFurniture();
                case 2 -> {
                    designer.addColorScheme();
                }
                case 3 -> {
                    designer.addFurnitureLayout();
                }
                case 4 -> {
                    designer.addLighting();
                }
                case 5 -> designer.describeInterior();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}