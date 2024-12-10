class Child extends FamilyMember {
    public Child(String name) {
        super(name);
    }

    @Override
    public void handleTask(Task task) {
        task.perform(getName());
    }
}