package geekbrains.java1.l6.Animals;

public class Hamster extends Animal {
    public Hamster(String name, int runDistanceRestriction, int swimDistanceRestriction, int jumpHeightRestriction){
        this.name = name;
        this.runDistanceRestriction = runDistanceRestriction;
        this.swimDistanceRestriction = swimDistanceRestriction;
        this.jumpHeightRestriction = jumpHeightRestriction;
    }
    @Override
    public void run(int runDistance) {
        if (runDistance > runDistanceRestriction) {
            System.out.println("Hamster " + name + " is unable to run this distance.");
        } else {
            System.out.println("Hamster " + name + " ran " + runDistance + " sm.");
        }
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance > swimDistanceRestriction) {
            System.out.println("Hamster " + name + " is unable to run this distance.");
        } else {
            System.out.println("Hamster " + name + " swam " + swimDistance + " sm.");
        }
    }

    @Override
    public void jump(int jumpHeight) {
        if (jumpHeight > jumpHeightRestriction) {
            System.out.println("Hamster " + name + " is unable to jump so high.");
        } else {
            System.out.println("Hamster " + name + " jumped " + jumpHeight + " sm.");
        }
    }
}
