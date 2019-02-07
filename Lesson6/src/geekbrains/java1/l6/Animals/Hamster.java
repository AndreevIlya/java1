package geekbrains.java1.l6.Animals;

public class Hamster extends Animal implements IAnimalLife{
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

    @Override
    public void findFood() {
        System.out.println("Hello, i'm hamster " + name + ". I'm brooding about food... Where could it be?");
        System.out.println("Nothing under the carpet, nothing behind the pool and still nothing near my bed.");
        System.out.println("Nothing eatable around, except... this paper box? Ahh... delicious!");
        System.out.println();
    }
}
