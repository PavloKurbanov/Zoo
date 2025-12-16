package ZooManagement.zoo.enclosures;

import ZooManagement.zoo.animals.Animal;
import ZooManagement.zoo.animals.Bird;
import ZooManagement.zoo.animals.Mammal;

public class Cage extends Enclosure {

    public Cage(int id, String type) {
        super(id, type);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Mammal)){
            throw new IllegalArgumentException(animal.getName() + " is a " + animal.getSpecies() + " and cannot be added to a Cage (only for Bird).");
        }
        super.addAnimal(animal);
    }
}
