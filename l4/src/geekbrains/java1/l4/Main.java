package geekbrains.java1.l4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int SIZE = 5;
    private static int DOTS_TO_WIN = 5;
    private static char[][] map;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        for(int i = 0; i < SIZE * SIZE; i++) {
            humanTurn();
            System.out.println("Ситуация после вашего хода:");
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            aiTurn();
            System.out.println("Ситуация после хода компьютера:");
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Вы проиграли ;(");
                break;
            }
            if (i == SIZE * SIZE - 1) System.out.println("Ничья ;(");
        }
    }

    private static void initMap(){
        map = new char [SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X (столбец) Y (строка)");
            try {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }catch(Exception exc){
                System.out.println("Только числа можно вводить!");
                x = - 1;
                y = - 1;
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return (map[y][x] == DOT_EMPTY);
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    private static boolean checkWin(char letter) {
        for(int i = 0; i < SIZE; i++) {// Check lines
            int counter = 0;
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == letter) {
                    counter++;
                    //System.out.println(map[i][j] + " " + counter);
                    if (counter == DOTS_TO_WIN) return true;
                } else {
                    counter = 0;
                    //System.out.println(map[i][j] + " " + counter);
                }
            }
        }
        //System.out.println();
        for(int i = 0; i < SIZE; i++){//Check columns
            int counter = 0;
            for(int j = 0; j < SIZE; j++) {
                if (map[j][i] == letter) {
                    counter++;
                    //System.out.println(map[j][i] + " " + counter);
                    if (counter == DOTS_TO_WIN) return true;
                } else {
                    counter = 0;
                    //System.out.println(map[j][i] + " " + counter);
                }
            }
        }
        for(int i = 0; i <= SIZE - DOTS_TO_WIN; i++){
            int counterL = 0;
            int counterR = 0;
            for(int j = i; j < SIZE; j++) {
                if (map[j][j] == letter) {
                    counterL++;
                    if (counterL == DOTS_TO_WIN) return true;
                } else counterL = 0;
                if (map[SIZE - j - 1][j] == letter) {
                    counterR++;
                    if (counterR == DOTS_TO_WIN) return true;
                } else counterR = 0;
            }
        }
        return false;
    }
}
