class Cooking implements Task {
    @Override
    public void perform(String name) {
        System.out.println(name + " is cooking dinner.");
    }
}