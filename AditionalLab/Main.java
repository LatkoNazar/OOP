import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<FamilyMember> family = new ArrayList<>();
        Parent mother = new Parent("Jane");
        Parent father = new Parent("Cole");
        Child child = new Child("Bob");
        TaskController controller = new TaskController(List.of(new Cleaning(), new Cooking(), new KidsEducation()),
                List.of(mother, father, child));
        controller.distributeTasks();
    }
}
