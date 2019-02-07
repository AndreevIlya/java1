package geekbrains.java1.l6;

import geekbrains.java1.l6.Animals.Cat;
import geekbrains.java1.l6.Animals.Hamster;

public class Main {

    public static void main(String[] args) {
	    Cat cat1 = new Cat("Sam",200,3);
        Cat cat2 = new Cat("Guenter",150,1);
        Cat cat3 = new Cat("Scavenger",500,4);

        cat1.exercise(150,100,2);
        cat1.exercise(300,200,6);

        cat2.exercise(50,100,1);
        cat2.exercise(200,10,2);

        cat3.exercise(450,10,3);
        cat3.exercise(80,100,5);

        Hamster ham1 = new Hamster ("Bean", 150, 30, 15);
        Hamster ham2 = new Hamster ("Alex", 350, 100, 30);

        ham1.exercise(200,15,10);
        ham2.exercise(200,120,40);
    }
}
