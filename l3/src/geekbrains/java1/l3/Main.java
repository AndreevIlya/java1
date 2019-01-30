package geekbrains.java1.l3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("What game do u wanna play? #1 or #2?");
        byte game = scanner.nextByte();
        if(game == 1) doTask1();
        else if(game == 2) doTask2();
        else System.out.println("U don't wanna play... ;(");

        scanner.close();
    }
    private static void doTask1(){
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
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessed, answer;
        char[] firstLetters = new char[15];
        guessed = words[rand.nextInt(words.length)];
        System.out.println("Guess a word from a list:");
        System.out.println(Arrays.toString(words));
        while(true) {
            answer = scanner.nextLine();
            if (answer.equals(guessed)) {
                System.out.printf("U won! Guessed was %s.\n", answer);
                break;
            } else {
                for (int i = 0; i < firstLetters.length; i++) {
                    firstLetters[i] = '#';
                }
                for (int i = 0; i < answer.length() && i < guessed.length(); i++) {
                    if (answer.charAt(i) == guessed.charAt(i)) firstLetters[i] = guessed.charAt(i);
                }
                System.out.println("Guess in progress:");
                wordParser(firstLetters);
            }
        }
    }
    private static void wordParser(char[] arr){
        for (char c : arr) {
            System.out.print(c);
        }
        System.out.println();
    }
}
