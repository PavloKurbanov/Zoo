package ZooManagement.zoo.enclosures;

import ZooManagement.animals.Animal;
import ZooManagement.staff.Worker;

public abstract class Enclosure {
    private final int id;
    private final String type;
    private Worker worker;

    private Animal[] animals;
    private int animalCount;

    public Enclosure(int id, String type) {
        if(type == null || type.isBlank()){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.type = type;
        this.animals = new Animal[5];
    }

    public void addAnimal(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("Cannot add null animal.");
        }
        if(isFull()){
            throw new IllegalArgumentException("Enclosure " + getId() + " is full. Cannot add " + animal.getName());
        }
        if(isDuplicate(animal)){
            throw new IllegalArgumentException("The animal " + animal.getName() + " is already in the enclosure.");
        }
        animals[animalCount++] = animal;
        animal.setEnclosure(this);
        System.out.println("Enclosure added: " + animal.getName());
    }

    public void removeAnimal(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("Cannot remove null animal.");
        }

        int indexToRemove = -1;

        for (int i = 0; i < animalCount; i++) {
            if(animals[i].equals(animal)){
                indexToRemove = i;
                break;
            }
        }

        if(indexToRemove == -1){
            throw new IllegalArgumentException("Animal " + animal.getName() + " is not in the enclosure " + this.getId() + ".");
        }

        animal.setEnclosure(null);

        for (int j = indexToRemove; j < animalCount - 1; j++) {
            animals[j] = animals[j + 1];
        }
        animalCount--;
        System.out.println("Enclosure " + getId() + " removed: " + animal.getName() + ".");
    }

    public void feedAnimals(){
        if(worker == null){
            System.out.println("Enclosure " + getId() + " has no worker.");
            return;
        }
        System.out.println("Enclosure " + getId() + " feeding animals.");
        for(int i = 0; i < animalCount; i++){
            animals[i].makeSound();
            System.out.println("Keeper " + worker.getName() + " feeded: " + animals[i].getName() + ".");
        }
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    private boolean isFull(){
        return animalCount == animals.length;
    }

    private boolean isDuplicate(Animal animal){
        for (Animal currentAnimal : animals) {
            if(currentAnimal != null){
                if(currentAnimal.equals(animal)){
                    return true;
                }
            }
        }
        return false;
    }
}
