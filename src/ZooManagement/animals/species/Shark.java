package ZooManagement.zoo.animals.species;

import ZooManagement.animals.Fish;
import ZooManagement.animals.interfaces.CanSwim;

public class Shark extends Fish implements CanSwim {

    public Shark(String name, int age) {
        super(name, age, "Fish");
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " is making Bulllll!");
    }

    @Override
    public void swim() {
        System.out.println(this.getName() + " swims, because he is a " + getSpecies());
    }
}
