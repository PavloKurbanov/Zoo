package ZooManagement.zoo;



import ZooManagement.zoo.animals.species.Lion;
import ZooManagement.zoo.animals.species.Parrot;
import ZooManagement.zoo.animals.species.Shark;
import ZooManagement.zoo.enclosures.Aviary;
import ZooManagement.zoo.enclosures.Cage;
import ZooManagement.zoo.enclosures.WaterEnclosure;
import ZooManagement.zoo.staff.Keeper;
import ZooManagement.zoo.staff.Vet;
import ZooManagement.zoo.staff.workerRole.WorkerRole;
import ZooManagement.zoo.zoo.Zoo;


public class Main {
    public static void main(String[] args) {
        // 1. СТВОРЕННЯ ЗООПАРКУ
        Zoo myZoo = new Zoo();

        // 2. СТВОРЕННЯ МЕШКАНЦІВ
        Lion simba = new Lion("Simba", 5);
        Parrot kesha = new Parrot("Kesha", 2);
        Shark jaws = new Shark("Jaws", 7);

        // 3. СТВОРЕННЯ ВОЛЬЄРІВ
        Cage lionCage = new Cage(1, "Ground");
        Aviary birdAviary = new Aviary(2, "Air");
        WaterEnclosure sharkTank = new WaterEnclosure(3, "Water");

        // 4. СТВОРЕННЯ ПЕРСОНАЛУ
        Keeper mammalKeeper = new Keeper("Ivan", WorkerRole.MAMMAL_KEEPER);
        Vet zooVet = new Vet("Dr. House", WorkerRole.BIRD_SPECIALIST);

        System.out.println("=== ЕТАП 1: РЕЄСТРАЦІЯ В ЗООПАРКУ ===");
        myZoo.addAnimal(simba);
        myZoo.addAnimal(kesha);
        myZoo.addAnimal(jaws);
        myZoo.addEnclosure(lionCage);
        myZoo.addEnclosure(birdAviary);
        myZoo.addEnclosure(sharkTank);
        myZoo.addWorker(mammalKeeper);
        myZoo.addWorker(zooVet);

        System.out.println("\n=== ЕТАП 2: РОЗПОДІЛ ТВАРИН (ПЕРЕВІРКА ТИПІВ) ===");
        try {
            // Тут спрацює логіка Cage (instanceof Mammal)
            myZoo.assignAnimalToEnclosure(simba, lionCage);

            // Тут спрацює логіка Aviary (instanceof Bird)
            myZoo.assignAnimalToEnclosure(kesha, birdAviary);

            // ТЕСТ ПОМИЛКИ: спробуємо запхати акулу до птахів
            System.out.println("Спроба поселити акулу до птахів...");
            myZoo.assignAnimalToEnclosure(jaws, birdAviary);
        } catch (IllegalArgumentException e) {
            // Ми побачимо повідомлення про те, що Shark - не Bird
            System.out.println("ВІДМОВА: " + e.getMessage());
        }

        System.out.println("\n=== ЕТАП 3: ПРИЗНАЧЕННЯ ПЕРСОНАЛУ (ПЕРЕВІРКА РОЛЕЙ) ===");
        try {
            // Іван - MAMMAL_KEEPER, тому Cage йому підходить
            myZoo.assignWorkerToEnclosure(mammalKeeper, lionCage);

            // Доктор Хаус - BIRD_SPECIALIST, тому Aviary йому підходить
            myZoo.assignWorkerToEnclosure(zooVet, birdAviary);

            // ТЕСТ ПОМИЛКИ: Чи може Іван (доглядач ссавців) працювати з акулами (WaterEnclosure)?
            System.out.println("Спроба призначити доглядача ссавців на акваріум...");
            myZoo.assignWorkerToEnclosure(mammalKeeper, sharkTank);
        } catch (IllegalArgumentException e) {
            // Спрацює метод isRoleCompatible з класу Worker
            System.out.println("ВІДМОВА: " + e.getMessage());
        }

        System.out.println("\n=== ЕТАП 4: ДЕМОНСТРАЦІЯ МОЖЛИВОСТЕЙ (ІНТЕРФЕЙСИ) ===");
        // Кожна тварина показує те, що вона вміє через інтерфейси
        simba.run();    // CanRun
        kesha.fly();    // CanFly
        jaws.swim();    // CanSwim
        simba.giveBirth(); // Метод Mammal
        kesha.layEggs();   // Метод Bird

        System.out.println("\n=== ЕТАП 5: РОБОЧИЙ ДЕНЬ (ПОЛІМОРФІЗМ) ===");
        // Keeper просто годує
        mammalKeeper.feedAnimals();
        mammalKeeper.cleanEnclosures();

        System.out.println("---");

        // Vet спочатку перевіряє здоров'я, потім годує (інша реалізація того ж методу)
        zooVet.feedAnimals();
        zooVet.cleanEnclosures();

        System.out.println("\n=== ЕТАП 6: ПЕРЕВІРКА ДУБЛІКАТІВ ТА ЛІМІТІВ ===");
        try {
            // Спробуємо додати Сімбу ще раз у той самий вольєр
            myZoo.assignAnimalToEnclosure(simba, lionCage);
        } catch (IllegalArgumentException e) {
            System.out.println("ЗАХИСТ: " + e.getMessage());
        }

        System.out.println("\nЗоопарк успішно пройшов тестування!");
    }
}