class Parent extends FamilyMember {
    public Parent(String name) {
        super(name);
    }

    @Override
    public void handleTask(Task task) {
        task.perform(getName());
    }
}