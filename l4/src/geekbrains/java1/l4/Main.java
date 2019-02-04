package geekbrains.java1.l4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int SIZE = 6;
    private static int DOTS_TO_WIN = 4;
    private static int ALERT_LEVEL = 2;//AI starts to interrupt your lines
    // when you are in up to ALERT_LEVEL cells to close it
    private static char[][] map;
    private static int[][] turn = new int[DOTS_TO_WIN][3];

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
        //I used random to make AI strategy unpredictable
        int choice = rand.nextInt(1650); //50 is added to let some possibility of an AI mistake
        if(!(winLines() || winColumns() || winDiagL() || winDiagR() || winDiagLA() || winDiagLB() || winDiagRA() || winDiagRB())) {
            if (choice < 200) {
                if (!checkLines() && !checkColumns() && !checkDiagL() && !checkDiagR() && !checkDiagLA() && !checkDiagLB() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 400) {
                if (!checkColumns() && !checkLines() && !checkDiagL() && !checkDiagR() && !checkDiagLA() && !checkDiagLB() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 600) {
                if (!checkDiagL() && !checkLines() && !checkColumns() && !checkDiagR() && !checkDiagLA() && !checkDiagLB() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 800) {
                if (!checkDiagR() && !checkLines() && !checkColumns() && !checkDiagL() && !checkDiagLA() && !checkDiagLB() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 1000) {
                if (!checkDiagLA() && !checkLines() && !checkColumns() && !checkDiagL() && !checkDiagR() && !checkDiagLB() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 1200) {
                if (!checkDiagLB() && !checkLines() && !checkColumns() && !checkDiagL() && !checkDiagR() && !checkDiagLA() && !checkDiagRA() && !checkDiagRB()) aiRandom();
            } else if (choice < 1400) {
                if (!checkDiagRA() && !checkLines() && !checkColumns() && !checkDiagL() && !checkDiagR() && !checkDiagLA() && !checkDiagLB() && !checkDiagRB()) aiRandom();
            } else if (choice < 1600) {
                if (!checkDiagRB() && !checkLines() && !checkColumns() && !checkDiagL() && !checkDiagR() && !checkDiagLA() && !checkDiagLB() && !checkDiagRA()) aiRandom();
            } else aiRandom();
        }
    }
    private static boolean checkWin(char letter) {
        for(int i = 0; i < SIZE; i++) {// Check lines
            int counter = 0;
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == letter) {
                    counter++;
                    if (counter == DOTS_TO_WIN) return true;
                } else counter = 0;
            }
        }
        for(int i = 0; i < SIZE; i++){//Check columns
            int counter = 0;
            for(int j = 0; j < SIZE; j++) {
                if (map[j][i] == letter) {
                    counter++;
                    if (counter == DOTS_TO_WIN) return true;
                } else counter = 0;
            }
        }
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {//Diagonals
            int counterL = 0;
            int counterR = 0;
            for (int j = i; j < SIZE; j++) {
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
        for(int k = 1; k <= SIZE - DOTS_TO_WIN; k++) {
            for (int i = 0; i <= SIZE - DOTS_TO_WIN - k; i++) {
                int counterLBelow = 0;
                int counterRBelow = 0;
                int counterLAbove = 0;
                int counterRAbove = 0;
                for (int j = i; j < SIZE - k; j++) {
                    if (map[j + k][j] == letter) {//Below diagonal
                        counterLBelow++;
                        if (counterLBelow == DOTS_TO_WIN) return true;
                    } else counterLBelow = 0;
                    if (map[SIZE - j - 1 - k][j] == letter) {
                        counterRBelow++;
                        if (counterRBelow == DOTS_TO_WIN) return true;
                    } else counterRBelow = 0;
                    if (map[j][j + k] == letter) {//Above diagonal
                        counterLAbove++;
                        if (counterLAbove == DOTS_TO_WIN) return true;
                    } else counterLAbove = 0;
                    if (map[SIZE - j - 1][j + k] == letter) {
                        counterRAbove++;
                        if (counterRAbove == DOTS_TO_WIN) return true;
                    } else counterRAbove = 0;
                }
            }
        }
        return false;
    }
    private static void aiRandom(){
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        System.out.println("RКомпьютер походил в точку " + (x + 1) + " " + (y + 1));
    }
    private static boolean checkLines(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++){
            for(int i = 0; i < SIZE; i++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = i;
                        turn[s][1] = k;
                        if (map[i][k] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[i][k] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkColumns(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for(int i = 0; i < SIZE; i++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++){
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = k;
                        turn[s][1] = i;
                        if (map[k][i] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[k][i] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagL(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = k;
                    turn[s][1] = k;
                    if (map[k][k] == DOT_X) {
                        counter++;
                        turn[s][2] = 1;
                    } else if (map[k][k] == DOT_O) {
                        turn[s][2] = 2;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,p, true);
                if (turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagLB(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN - n && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = k + n;
                        turn[s][1] = k;
                        if (map[k + n][k] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[k + n][k] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagLA(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN - n && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = k;
                        turn[s][1] = k + n;
                        if (map[k][k + n] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[k][k + n] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagR(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = SIZE - k - 1;
                    turn[s][1] = k;
                    if (map[SIZE - k - 1][k] == DOT_X) {
                        counter++;
                        turn[s][2] = 1;
                    } else if (map[SIZE - k - 1][k] == DOT_O) {
                        turn[s][2] = 2;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,p, true);
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagRB(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN - n + 1 && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = SIZE - k - 1;
                        turn[s][1] = k + n;
                        if (map[SIZE - k - 1][k + n] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[SIZE - k - 1][k + n] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagRA(){
        int counter;
        boolean turnDone = false;
        for (int p = 1; p <= ALERT_LEVEL; p++) {
            for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                    counter = 0;
                    for (int k = j, s = 0; k < j + DOTS_TO_WIN - n + 1 && s < DOTS_TO_WIN; k++, s++) {
                        turn[s][0] = SIZE - k - 1 - n;
                        turn[s][1] = k;
                        if (map[SIZE - k - 1 - n][k] == DOT_X) {
                            counter++;
                            turn[s][2] = 1;
                        } else if (map[SIZE - k - 1 - n][k] == DOT_O) {
                            turn[s][2] = 2;
                        } else {
                            turn[s][2] = 0;
                        }
                    }
                    turnDone = assign(counter,p, true);
                    if (turnDone) break;
                }
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    //Here start the methods by which AI can win immediately
    private static boolean winLines(){
        int counter;
        boolean turnDone = false;
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++){
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = i;
                    turn[s][1] = k;
                    if (map[i][k] == DOT_X) {
                        turn[s][2] = 1;
                    } else if (map[i][k] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean winColumns(){
        int counter;
        boolean turnDone = false;
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++){
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = k;
                    turn[s][1] = i;
                    if (map[k][i] == DOT_X) {
                        turn[s][2] = 1;
                    } else if (map[k][i] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean winDiagL(){
        int counter;
        boolean turnDone = false;
        for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
            counter = 0;
            for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                turn[s][0] = k;
                turn[s][1] = k;
                if (map[k][k] == DOT_X) {
                    turn[s][2] = 1;
                } else if (map[k][k] == DOT_O) {
                    turn[s][2] = 2;
                    counter++;
                } else {
                    turn[s][2] = 0;
                }
            }
            turnDone = assign(counter,1, false);
        }
        return turnDone;
    }
    private static boolean winDiagLB(){
        int counter;
        boolean turnDone = false;
        for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN - n && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = k + n;
                    turn[s][1] = k;
                    if (map[k + n][k] == DOT_X) {
                        turn[s][2] = 1;
                    } else if (map[k + n][k] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean winDiagLA(){
        int counter;
        boolean turnDone = false;
        for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN - n && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = k;
                    turn[s][1] = k + n;
                    if (map[k][k + n] == DOT_X) {
                        turn[s][2] = 1;
                    } else if (map[k][k + n] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean winDiagR(){
        int counter;
        boolean turnDone = false;
        for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
            counter = 0;
            for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                turn[s][0] = SIZE - k - 1;
                turn[s][1] = k;
                if (map[SIZE - k - 1][k] == DOT_X) {
                    turn[s][2] = 1;

                } else if (map[SIZE - k - 1][k] == DOT_O) {
                    turn[s][2] = 2;
                    counter++;
                } else {
                    turn[s][2] = 0;
                }
            }
            turnDone = assign(counter,1, false);
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean winDiagRB(){
        int counter;
        boolean turnDone = false;
        for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN - n + 1 && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = SIZE - k - 1;
                    turn[s][1] = k + n;
                    if (map[SIZE - k - 1][k + n] == DOT_X) {
                        turn[s][2] = 1;
                    } else if (map[SIZE - k - 1][k + n] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean winDiagRA(){
        int counter;
        boolean turnDone = false;
        for(int n = 1; n <= SIZE - DOTS_TO_WIN; n++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN - n; j++) {
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN - n + 1 && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = SIZE - k - 1 - n;
                    turn[s][1] = k;
                    if (map[SIZE - k - 1 - n][k] == DOT_X) {
                        turn[s][2] = 1;

                    } else if (map[SIZE - k - 1 - n][k] == DOT_O) {
                        turn[s][2] = 2;
                        counter++;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                turnDone = assign(counter,1, false);
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean assign(int counter, int p, boolean checkO){
        if (counter >= DOTS_TO_WIN - p) {
            for (int m = 0; m < DOTS_TO_WIN; m++) {
                if (turn[m][2] == 2 && checkO) {
                    return false;
                } else if (turn[m][2] == 0) {
                    map[turn[m][0]][turn[m][1]] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                    return true;
                }
            }
        }
        return false;
    }
}
