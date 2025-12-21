package ZooManagement.zoo.enclosures;

import ZooManagement.zoo.animals.Animal;
import ZooManagement.zoo.animals.Bird;
import ZooManagement.zoo.animals.Mammal;
import ZooManagement.zoo.staff.workerRole.WorkerRole;

public class Aviary extends Enclosure {

    public Aviary(int id, String type, WorkerRole workerRole) {
        super(id, type, WorkerRole.MAMMAL_KEEPER);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Bird)){
            throw new IllegalArgumentException(animal.getName() + " is a " + animal.getSpecies() + " and cannot be added to a Aviary (only for Mammals).");
        }
        super.addAnimal(animal);
    }
}
