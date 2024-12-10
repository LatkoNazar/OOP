class Child extends FamilyMember {
    public Child(String name) {
        super(name);
    }

    @Override
    public void handleTask(Task task) {
        System.out.print(getName() + " is doing: ");
        task.perform(getName());
    }
}