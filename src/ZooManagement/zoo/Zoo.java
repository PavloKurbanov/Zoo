package ZooManagement.zoo.zoo;

import ZooManagement.zoo.animals.Animal;
import ZooManagement.zoo.enclosures.Enclosure;
import ZooManagement.zoo.staff.Worker;

public class Zoo {
    private final Animal[] animals;
    private final Enclosure[] enclosures;
    private final Worker[] workers;

    private int animalCount;
    private int enclosureCount;
    private int workerCount;

    public Zoo(){
        animals = new Animal[3];
        enclosures = new Enclosure[3];
        workers = new Worker[3];
    }

    public void addAnimal(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("Cannot add null animal");
        }
        if(isAnimalFull()){
            throw  new IllegalArgumentException("Animal is already full");
        }
        if(isAnimalDuplicate(animal)){
            throw new IllegalArgumentException("Animal is already duplicate");
        }
        animals[animalCount++] = animal;
        System.out.println("Animal " + animal.getName() + " has been added to ZOO " + this.getClass().getSimpleName());
    }

    public void addEnclosure(Enclosure enclosure){
        if(enclosure == null){
            throw new IllegalArgumentException("Cannot add null enclosure");
        }
        if(isEnclosureFull()){
            throw  new IllegalArgumentException("Enclosure is already full");
        }
        if(isEnclosureDuplicate(enclosure)){
            throw new IllegalArgumentException("Enclosure is already duplicate");
        }
        enclosures[enclosureCount++] = enclosure;
        System.out.println("Enclosure added to ZOO " + this.getClass().getSimpleName());
    }

    public void addWorker(Worker worker){
        if(worker == null){
            throw new IllegalArgumentException("Cannot add null worker");
        }
        if(isWorkerFull()){
            throw  new IllegalArgumentException("Worker is already full");
        }
        if(isWorkerDuplicate(worker)){
            throw new IllegalArgumentException("Worker is already duplicate");
        }
        workers[workerCount++] = worker;
        System.out.println("Worker " + worker.getName() + " has been added to ZOO " + this.getClass().getSimpleName());
    }

    public void showAllAnimals(){
        if(animalCount == 0){
            System.out.println("No animals have been added to ZOO");
        } else {
            System.out.println("Info about animals in ZOO " + this.getClass().getSimpleName() + ":");
            for (Animal currentAnimal : animals) {
                if (currentAnimal != null) {
                    currentAnimal.getInfo();
                }
            }
        }
    }

    public void assignWorkerToEnclosure(Worker worker, Enclosure enclosure){
        if(worker == null || enclosure == null){
            throw new IllegalArgumentException("Cannot assign null worker or enclosure");
        }
        worker.assignEnclosure(enclosure);
        System.out.println("Worker " + worker.getName() + " assigned to enclosure " + this.getClass().getSimpleName());
    }

    public void assignAnimalToEnclosure(Animal animal, Enclosure enclosure){
        if(animal == null || enclosure == null){
            throw new IllegalArgumentException("Cannot assign null animal or enclosure");
        }
        enclosure.addAnimal(animal);
        System.out.println("Zoo " + this.getClass().getSimpleName() + ": Management has assigned " + animal.getName() +
                " to enclosure " + enclosure.getClass().getSimpleName());
    }

    private boolean isAnimalFull(){
        return animalCount == animals.length;
    }

    private boolean isWorkerFull(){
        return workerCount == workers.length;
    }

    private boolean isEnclosureFull(){
        return enclosureCount == enclosures.length;
    }

    private boolean isAnimalDuplicate(Animal animal){
        for (int i = 0; i < animalCount; i++) {
            if(animals[i].equals(animal)){
                return true;
            }
        }
        return false;
    }

    private boolean isWorkerDuplicate(Worker worker){
        for (int i = 0; i < workerCount; i++) {
            if(workers[i].equals(worker)){
                return true;
            }
        }
        return false;
    }

    private boolean isEnclosureDuplicate(Enclosure enclosure){
        for (int i = 0; i < enclosureCount; i++) {
            if(enclosures[i].equals(enclosure)){
                return true;
            }
        }
        return false;
    }
}
