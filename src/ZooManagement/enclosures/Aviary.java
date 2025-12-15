package ZooManagement.enclosures;

import ZooManagement.animals.Animal;
import ZooManagement.animals.Bird;
import ZooManagement.animals.Mammal;

public class Aviary extends Enclosure {

    public Aviary(int id, String type) {
        super(id, type);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Bird)){
            throw new IllegalArgumentException(animal.getName() + " is a " + animal.getSpecies() + " and cannot be added to a Aviary (only for Mammals).");
        }
        super.addAnimal(animal);
    }
}
