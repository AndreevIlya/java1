package geekbrains.java1.l6.Animals;

public class Cat extends Animal{

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
}
