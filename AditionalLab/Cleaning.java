class Cleaning implements Task {
    @Override
    public void perform(String name) {
        System.out.println(name + " is cleaning the house.");
    }
}