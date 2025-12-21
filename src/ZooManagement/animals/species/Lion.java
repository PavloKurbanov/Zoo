package ZooManagement.zoo.animals.species;

import ZooManagement.zoo.animals.Mammal;
import ZooManagement.zoo.animals.interfaces.Runnable;

public class Lion extends Mammal implements Runnable {

    public Lion(String name, int age) {
        super(name, age, "Lion");
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " is making Rooooar! \uD83E\uDD81");
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " runs, because he is a " + getSpecies());
    }
}
