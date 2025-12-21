package ZooManagement.zoo.enclosures;

import ZooManagement.zoo.animals.Animal;
import ZooManagement.zoo.animals.Fish;
import ZooManagement.zoo.staff.workerRole.WorkerRole;

public class WaterEnclosure extends Enclosure {

    public WaterEnclosure(int id, String type, WorkerRole workerRole) {
        super(id, type, WorkerRole.FISH_KEEPER);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Fish)){
            throw new IllegalArgumentException(animal.getName() + " is a " + animal.getSpecies() + " and cannot be added to a WaterEnclosure (only for Fish).");
        }
        super.addAnimal(animal);
    }
}
