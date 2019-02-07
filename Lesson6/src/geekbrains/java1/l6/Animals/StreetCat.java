package geekbrains.java1.l6.Animals;

public class StreetCat extends Animal implements IAnimalLife {
    public StreetCat(int runDistanceRestriction, int swimDistanceRestriction, int jumpHeightRestriction){
        this.swimDistanceRestriction = swimDistanceRestriction;
        this.runDistanceRestriction = runDistanceRestriction;
        this.jumpHeightRestriction = jumpHeightRestriction;
    }

    @Override
    void run(int runDistance) {
        if (runDistance > runDistanceRestriction) {
            System.out.println("No matter the distance, street cat ran " + runDistance + " m.");
        } else {
            System.out.println("Street cat ran " + runDistance + " m.");
        }
    }

    @Override
    void swim(int swimDistance) {
        if(swimDistance > swimDistanceRestriction){
        System.out.println("No matter the distance, street cat swam " + swimDistance + " m.");
        } else {
            System.out.println("Street cat swam " + swimDistance + " m.");
        }
    }

    @Override
    void jump(int jumpHeight) {
        if (jumpHeight > jumpHeightRestriction) {
            System.out.println("Even street cat is unable to jump so high.");
        } else {
            System.out.println("Street cat jumped " + jumpHeight + " m.");
        }
    }

    @Override
    public void findFood() {
        System.out.println("Hi, i'm a street cat. I want to sleep, but to eat more.");
        System.out.println("Hunting mice? Hunting birds? Hunting dogs?");
        System.out.println("No good. In that house window is open! Chicken prepared to get roasted? Let's save it from fire!");
        System.out.println();
    }
}
