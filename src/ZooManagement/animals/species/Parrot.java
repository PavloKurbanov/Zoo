package ZooManagement.zoo.animals.species;

import ZooManagement.zoo.animals.Bird;
import ZooManagement.zoo.animals.interfaces.Flyable;

public class Parrot extends Bird implements Flyable {

    public Parrot(String name, int age) {
        super(name, age, "Bird");
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " flies, because he is a " + getSpecies());
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " makes Kukuriky!");
    }
}
