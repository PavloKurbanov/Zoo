package ZooManagement.zoo.staff;

import ZooManagement.zoo.enclosures.Aviary;
import ZooManagement.zoo.enclosures.Cage;
import ZooManagement.zoo.enclosures.Enclosure;
import ZooManagement.zoo.enclosures.WaterEnclosure;
import ZooManagement.zoo.staff.workerRole.WorkerRole;

import java.util.Objects;

public abstract class Worker {
    private final String name;
    private final WorkerRole role;

    private final Enclosure[] enclosures;
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

    public void assignEnclosure(Enclosure enclosure) {
        if(enclosure == null){
            throw new IllegalArgumentException("Cannot add null enclosure");
        }
        if(isFull()){
            throw new IllegalStateException("Worker " + getName() + " has no place for enclosure " + enclosure.getClass().getSimpleName());
        }
        if(isDuplicate(enclosure)){
            throw new IllegalArgumentException("Worker " + getName() + " has already place enclosure " + enclosure.getClass().getSimpleName());
        }
        if(!isRoleCompatible(enclosure)){
            throw new IllegalArgumentException("Worker " + getName() + " (Role: " + getRole() +
                    ") is not qualified for Enclosure type: " + enclosure.getClass().getSimpleName());
        }
        this.enclosures[enclosureCount++] = enclosure;
        enclosure.setWorker(this);
        System.out.println("Worker " + getName() + " has placed enclosure " + enclosure.getClass().getSimpleName());
    }

    protected Enclosure getEnclosure(int index) {
        if(index < 0 || index >= enclosureCount){
            throw new IllegalArgumentException("Invalid enclosure index: " + index);
        }
        return  enclosures[index];
    }

    public void removeEnclosure(Enclosure enclosure) {
        if(enclosure == null){
            throw new IllegalArgumentException("Cannot remove null enclosure");
        }

        int indexRemove = findEnclosureIndex(enclosure);

        if(indexRemove == -1){
            throw new IllegalArgumentException("Worker " + getName() + " has no place for enclosure " + enclosure.getClass().getSimpleName());
        }

        enclosure.setWorker(null);

        for(int j = indexRemove; j < enclosureCount - 1; j++){
            enclosures[j] = enclosures[j + 1];
        }
        enclosureCount--;
        System.out.println("Worker " + getName() + " has removed enclosure " + enclosure.getClass().getSimpleName());
    }

    private boolean isFull(){
        return enclosureCount == enclosures.length;
    }

    private boolean isDuplicate(Enclosure enclosure){
        return findEnclosureIndex(enclosure) != 1;
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

    private int findEnclosureIndex(Enclosure enclosure){
        for(int i = 0; i < enclosureCount; i++){
            if(enclosure.equals(enclosures[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) && role == worker.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
