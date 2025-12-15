package ZooManagement.animals;

public abstract class Mammal extends Animal{
    public Mammal(String name, int age, String species) {
        super(name, age, species);
    }

    public void giveBirth() {
        System.out.println(this.getName() + " gives birth");
    }
}
