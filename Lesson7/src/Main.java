import CatsAndPlates.Cat;
import CatsAndPlates.Plate;

import java.util.Random;

import static CatsAndPlates.Cat.feedCats;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Cat cat1 = new Cat("Sam",random.nextInt(20) + 10);
        Cat cat2 = new Cat("Guenter",random.nextInt(20) + 40);
        Cat cat3 = new Cat("Scavenger",random.nextInt(10) + 10);
        Cat cat4 = new Cat("Mouse",random.nextInt(5) + 5);
        Cat cat5 = new Cat("Mint",random.nextInt(10) + 20);
        Cat cat6 = new Cat("Winter",random.nextInt(20) + 20);
        Cat[] cats = {cat1,cat2,cat3,cat4,cat5,cat6};
        Plate plate = new Plate(random.nextInt(50));

        while(feedCats(plate, cats)){
            System.out.println();
        }

        System.out.println("\nAll the cats are fed!");
    }
}
