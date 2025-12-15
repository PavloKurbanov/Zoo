package ZooManagement.animals;

public abstract class Fish extends Animal{
    public Fish(String name, int age, String species) {
        super(name, age, species);
    }

    public void breathesUnderWater(){
        System.out.println(this.getName() + " breathes under water");
    }
}
