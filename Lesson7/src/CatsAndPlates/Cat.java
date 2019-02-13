package CatsAndPlates;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    private void eat(Plate plate) {
        if(plate.getFood() >= appetite){
            System.out.printf("Cat %s eats %d units of food.\n",name,appetite);
            plate.removeFood(appetite);
            plate.info();
            hungry = false;
        }else{
            System.out.printf("Cat %s refuses to eat because of lack of the food.\n",name);
        }
    }
    private boolean isHungry(){
        return hungry;
    }
    public static boolean feedCats(Plate plate, Cat[] cats){
        Random random = new Random();
        plate.addFood(random.nextInt(15) + 5);
        boolean satiated = false;
        for(Cat cat : cats){
            if(cat.isHungry()){
                cat.eat(plate);
                satiated = satiated || cat.isHungry();
            }
        }
        return satiated;
    }
}
