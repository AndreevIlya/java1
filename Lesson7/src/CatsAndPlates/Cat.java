package CatsAndPlates;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry = true;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate plate) {
        if(plate.getFood() >= appetite){
            System.out.printf("Cat %s eats %d units of food.\n",name,appetite);
            plate.removeFood(appetite);
            plate.info();
            hungry = false;
        }else{
            System.out.printf("Cat %s refuses to eat because of lack of the food.\n",name);
        }
    }
    public boolean isHungry(){
        return hungry;
    }
}
