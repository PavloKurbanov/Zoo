package ZooManagement.zoo.staff;

import ZooManagement.zoo.enclosures.Enclosure;
import ZooManagement.zoo.staff.workerRole.WorkerRole;

public class Keeper extends Worker {

    public Keeper(String name, WorkerRole role) {
        super(name, role);
    }

    @Override
    public void feedAnimals() {
        System.out.println("Keeper " + getName() + " starts his daily feeding round.");
        for (int i = 0; i < getEnclosureCount(); i++) {
            getEnclosure(i).feedAnimals();
        }
    }

    @Override
    public void cleanEnclosures() {
        System.out.println("Keeper " + getName() + " is scrubbing the floors of assigned enclosures.");
    }
}
