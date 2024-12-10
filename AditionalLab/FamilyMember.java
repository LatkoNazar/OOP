abstract class FamilyMember {
    private String name;
    private boolean available;

    public FamilyMember(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    public abstract void handleTask(Task task);
}