package CatsAndPlates;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    void info() {
        System.out.println("Plate: " + food);
    }
    void removeFood(int removedFood) {
        food -= removedFood;
    }
    void addFood(int addedFood) {
        System.out.printf("One put into the plate %d units of food.\n",addedFood);
        food += addedFood;
    }
    int getFood(){
        return this.food;
    }
}
