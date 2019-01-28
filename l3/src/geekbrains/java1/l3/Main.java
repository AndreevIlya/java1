package geekbrains.java1.l3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What game do u wanna play? #1 or #2?");
        byte game = scanner.nextByte();
        if(game == 1) doTask1();
        else if(game == 2) doTask2();
        else System.out.println("U don't wanna play... ;(");

        scanner.close();
    }
    private static void doTask1(){
        Random rand = new Random();
        int guessed,
            answer;
        byte attemptsRemain;
        boolean exit = true;
        do{
            guessed = rand.nextInt(10);
            attemptsRemain = 3;
            while(attemptsRemain != 0) {
                System.out.println("Guess a number from 0 to 9:");
                answer = scanner.nextInt();
                if (answer == guessed) {
                    System.out.printf("U won! Guessed was %d.\n", answer);
                    System.out.println("Do u want to play again? No = 0.");
                    exit = scanner.nextInt() != 0;
                    break;
                } else if (answer > guessed) {
                    attemptsRemain--;
                    System.out.println("Your answer is too big.");
                    exit = checkExit(attemptsRemain);
                } else {
                    attemptsRemain--;
                    System.out.println("Your answer is too small.");
                    exit = checkExit(attemptsRemain);
                }
            }
        }while(exit);
    }
    private static boolean checkExit(byte attemptsRemain){
        if (attemptsRemain != 0){
            System.out.printf("Try again. There remained %d attempts.\n", attemptsRemain);
            return true;
        }else {
            System.out.println("U've lost. Do u want to play again? No = 0.");
            return scanner.nextInt() != 0;
        }
    }
    private static void doTask2(){
        
    }
}
