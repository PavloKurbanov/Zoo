package ZooManagement.zoo.animals;

import ZooManagement.zoo.enclosures.Enclosure;

import java.util.Objects;

public abstract class Animal {
    private final String name;
    private final int age;
    private final String species;
    private Enclosure enclosure;

    public Animal(String name, int age, String species) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if(age < 0 || age > 20){
            throw new IllegalArgumentException("Age must be between 0 and 20");
        }
        if(species == null || species.isBlank()){
            throw new IllegalArgumentException("Species cannot be null or blank");
        }
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public abstract void makeSound();

    public void getInfo(){
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", Species: " + this.species);
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species);
    }
}
