package geekbrains.java1.l6.Animals;

public abstract class Animal {
    int runDistance;
    int swimDistance;
    int jumpHeight;

    public abstract void run(int runDistance);
    public abstract void swim(int swimDistance);
    public abstract void jump(int jumpHeight);

}
