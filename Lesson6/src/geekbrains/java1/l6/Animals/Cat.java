package geekbrains.java1.l6.Animals;

public class Cat extends Animal implements IAnimalLife{

    public Cat(String name, int runDistanceRestriction, int jumpHeightRestriction){
        this.name = name;
        this.runDistanceRestriction = runDistanceRestriction;
        this.jumpHeightRestriction = jumpHeightRestriction;
    }

    @Override
    void run(int runDistance) {
        if (runDistance > runDistanceRestriction) {
            System.out.println("Cat " + name + " is unable to run this distance.");
        } else {
            System.out.println("Cat " + name + " ran " + runDistance + " m.");
        }
    }

    @Override
    void swim(int swimDistance) {
        System.out.println("Neither cat is unable to swim at all.");
    }

    @Override
    void jump(int jumpHeight) {
        if (jumpHeight > jumpHeightRestriction) {
            System.out.println("Cat " + name + " is unable to jump so high.");
        } else {
            System.out.println("Cat " + name + " jumped " + jumpHeight + " m.");
        }
    }

    @Override
    public void findFood() {
        System.out.println("Hello, i'm cat " + name + ". I should stop sleeping. Mmm... Where is my food?");
        System.out.println("I went to that big white box, where food is stored. What to do to open it? Sure! MEEOOOOWW!!!");
        System.out.println("They came and delivered food to me. That's their work.");
        System.out.println();
    }
}
