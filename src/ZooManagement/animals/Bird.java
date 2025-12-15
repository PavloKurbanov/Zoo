package ZooManagement.animals;

public abstract class Bird extends Animal{
    public Bird(String name, int age, String species) {
        super(name, age, species);
    }

    public void layEggs(){
        System.out.println(this.getName() + " laying eggs");
    }
}
