package ZooManagement.animals.species;

import ZooManagement.animals.Bird;
import ZooManagement.animals.interfaces.CanFly;

public class Parrot extends Bird implements CanFly {

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
