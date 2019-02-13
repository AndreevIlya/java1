import CatsAndPlates.Cat;
import CatsAndPlates.Plate;

import java.util.Random;

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
        do{
           plate.addFood(random.nextInt(15) + 5);
           for(Cat cat : cats){
               if(cat.isHungry()){
                   cat.eat(plate);
               }
           }
        }while(cat1.isHungry() ||
                cat2.isHungry() ||
                cat3.isHungry() ||
                cat4.isHungry() ||
                cat5.isHungry() ||
                cat6.isHungry());
        System.out.println("\nAll the cats are fed!");
    }
}
