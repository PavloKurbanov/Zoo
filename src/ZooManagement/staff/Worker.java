package ZooManagement.zoo.staff;

import ZooManagement.enclosures.Aviary;
import ZooManagement.enclosures.Cage;
import ZooManagement.enclosures.Enclosure;
import ZooManagement.enclosures.WaterEnclosure;
import ZooManagement.staff.workerRole.WorkerRole;

import java.util.Objects;

public abstract class Worker {
    private final String name;
    private final WorkerRole role;

    private Enclosure[] enclosures;
    private int enclosureCount;

    public Worker(String name,  WorkerRole role) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(name + " is null or blank");
        }
        this.name = name;
        this.role = role;
        this.enclosures = new Enclosure[2];
    }

    public WorkerRole getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public int getEnclosureCount() {
        return enclosureCount;
    }

    public abstract void feedAnimals();

    public abstract void cleanEnclosures();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    private boolean isFull(){
        return enclosureCount == enclosures.length;
    }

    private boolean isDuplicate(){

    }

    private boolean isRoleCompatible(Enclosure enclosure) {
        if(this.role == WorkerRole.BIRD_SPECIALIST){
            return enclosure instanceof Aviary;
        }
        if(this.role == WorkerRole.FISH_KEEPER){
            return enclosure instanceof WaterEnclosure;
        }
        if(this.role == WorkerRole.MAMMAL_KEEPER){
            return enclosure instanceof Cage;
        }
        return false;
    }
}
