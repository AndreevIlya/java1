package geekbrains.java1.l6.Animals;

public abstract class Animal {
    int runDistanceRestriction;
    int swimDistanceRestriction;
    int jumpHeightRestriction;
    String name;

    abstract void run(int runDistance);
    abstract void swim(int swimDistance);
    abstract void jump(int jumpHeight);
    public void exercise(int runDistance, int swimDistance, int jumpHeight){
        this.run(runDistance);
        this.swim(swimDistance);
        this.jump(jumpHeight);
        System.out.println();
    }

}
