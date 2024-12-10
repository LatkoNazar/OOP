import java.util.ArrayList;
import java.util.List;

class TaskController {
    private List<Task> tasks;
    private List<FamilyMember> members;

    public TaskController(List<Task> tasks, List<FamilyMember> members) {
        this.tasks = tasks;
        this.members = members;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addMember(FamilyMember member) {
        members.add(member);
    }

    public void distributeTasks() {
        int memberIndex = 0;
        for (Task task : tasks) {
            FamilyMember member = members.get(memberIndex);
            member.handleTask(task);
            memberIndex = (memberIndex + 1) % members.size();
        }
    }
}