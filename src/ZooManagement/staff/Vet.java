package ZooManagement.zoo.staff;

import ZooManagement.zoo.enclosures.Enclosure;
import ZooManagement.zoo.staff.workerRole.WorkerRole;

public class Vet extends Worker{

    public Vet(String name, WorkerRole role) {
        super(name, role);
    }

    @Override
    public void feedAnimals() {
        System.out.println("Vet " + getName() + " is checking animals' health before feeding...");
        for (int i = 0; i < getEnclosureCount(); i++) {
            System.out.println("[Health Check: OK] ");
            getEnclosure(i).feedAnimals();
        }
    }

    @Override
    public void cleanEnclosures() {
        System.out.println("Vet " + getName() + " is disinfecting the enclosures to prevent diseases.");
    }
}
