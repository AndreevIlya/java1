package geekbrains.java1.l4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int SIZE = 5;
    private static int DOTS_TO_WIN = 4;
    private static int ALERT_LEVEL = 2;//AI starts to interrupt your lines
    // when you are in ALERT_LEVEL cells to close it
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
        int choice = rand.nextInt(1700); //To let some possibility of an AI mistake
        if(choice < 200) {
            if (!checkLines()) {
                if (!checkColumns()) {
                    if (!checkDiagL()) {
                        if (!checkDiagR()) {
                            if (!checkDiagLA()){
                                if (!checkDiagLB()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 400){
            if (!checkColumns()) {
                if (!checkLines()) {
                    if (!checkDiagL()) {
                        if (!checkDiagR()){
                            if (!checkDiagLA()){
                                if (!checkDiagLB()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 600){
            if (!checkDiagL()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagR()){
                            if (!checkDiagLA()){
                                if (!checkDiagLB()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 800){
            if (!checkDiagR()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagL()){
                            if (!checkDiagLA()){
                                if (!checkDiagLB()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 1000){
            if (!checkDiagLA()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagL()){
                            if (!checkDiagR()){
                                if (!checkDiagLB()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 1200){
            if (!checkDiagLB()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagL()){
                            if (!checkDiagR()){
                                if (!checkDiagLA()){
                                    if (!checkDiagRA()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 1400){
            if (!checkDiagRA()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagL()){
                            if (!checkDiagR()){
                                if (!checkDiagLA()){
                                    if (!checkDiagLB()){
                                        if (!checkDiagRB()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(choice < 1600){
            if (!checkDiagRB()) {
                if (!checkLines()) {
                    if (!checkColumns()) {
                        if (!checkDiagL()){
                            if (!checkDiagR()){
                                if (!checkDiagLA()){
                                    if (!checkDiagLB()){
                                        if (!checkDiagLA()) aiRandom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else aiRandom();
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
        int[][] turn = new int[DOTS_TO_WIN][3];
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++){
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
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL){
                    for (int m = 0; m < DOTS_TO_WIN; m++){
                        if(turn[m][2] == 2){
                            break;
                        }else if (turn[m][2] == 0) {
                            map[turn[m][0]][turn[m][1]] = DOT_O;
                            System.out.println("Компьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                            turnDone = true;
                            break;
                        }
                    }
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
        int[][] turn = new int[DOTS_TO_WIN][3];
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++){
                counter = 0;
                for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                    turn[s][0] = i;
                    turn[s][1] = k;
                    if (map[k][i] == DOT_X) {
                        counter++;
                        turn[s][2] = 1;

                    } else if (map[k][i] == DOT_O) {
                        turn[s][2] = 2;
                    } else {
                        turn[s][2] = 0;
                    }
                }
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL){
                    for (int m = 0; m < DOTS_TO_WIN; m++){
                        if(turn[m][2] == 2){
                            break;
                        }else if (turn[m][2] == 0) {
                            map[turn[m][1]][turn[m][0]] = DOT_O;
                            System.out.println("Компьютер походил в точку " + (turn[m][0] + 1) + " " + (turn[m][1] + 1));
                            turnDone = true;
                            break;
                        }
                    }
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
        int[][] turn = new int[DOTS_TO_WIN][3];
        for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
            counter = 0;
            for (int k = j, s = 0; k < j + DOTS_TO_WIN && s < DOTS_TO_WIN; k++, s++) {
                turn[s][0] = k;
                if (map[k][k] == DOT_X) {
                    counter++;
                    turn[s][2] = 1;

                } else if (map[k][k] == DOT_O) {
                    turn[s][2] = 2;
                } else {
                    turn[s][2] = 0;
                }
            }
            if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                for (int m = 0; m < DOTS_TO_WIN; m++) {
                    if (turn[m][2] == 2) {
                        break;
                    } else if (turn[m][2] == 0) {
                        map[turn[m][0]][turn[m][0]] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (turn[m][0] + 1) + " " + (turn[m][0] + 1));
                        turnDone = true;
                        break;
                    }
                }
            }
        }
        return turnDone;
    }
    private static boolean checkDiagLB(){
        int counter;
        boolean turnDone = false;
        int[][] turn = new int[DOTS_TO_WIN][3];
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
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                    for (int m = 0; m < DOTS_TO_WIN; m++) {
                        if (turn[m][2] == 2) {
                            break;
                        } else if (turn[m][2] == 0) {
                            map[turn[m][0]][turn[m][1]] = DOT_O;
                            System.out.println("LBКомпьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                            turnDone = true;
                            break;
                        }
                    }
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
        int[][] turn = new int[DOTS_TO_WIN][3];
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
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                    for (int m = 0; m < DOTS_TO_WIN; m++) {
                        if (turn[m][2] == 2) {
                            break;
                        } else if (turn[m][2] == 0) {
                            map[turn[m][0]][turn[m][1]] = DOT_O;
                            System.out.println("LAКомпьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                            turnDone = true;
                            break;
                        }
                    }
                }
                if(turnDone) break;
            }
            if(turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagR(){
        int counter, counterBelow, counterAbove;
        boolean turnDone = false;
        int[][] turn = new int[DOTS_TO_WIN][3];
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
            if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                for (int m = DOTS_TO_WIN - 1; m >= 0; m--) {
                    if (turn[m][2] == 2) {
                        break;
                    } else if (turn[m][2] == 0) {
                        map[turn[m][0]][turn[m][1]] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                        turnDone = true;
                        break;
                    }
                }
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean checkDiagRB(){
        int counter;
        boolean turnDone = false;
        int[][] turn = new int[DOTS_TO_WIN][3];
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
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                    for (int m = DOTS_TO_WIN - 1; m >= 0; m--) {
                        if (turn[m][2] == 2) {
                            break;
                        } else if (turn[m][2] == 0) {
                            map[turn[m][0]][turn[m][1]] = DOT_O;
                            System.out.println("RBКомпьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                            turnDone = true;
                            break;
                        }
                    }
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
        int[][] turn = new int[DOTS_TO_WIN][3];
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
                if (counter >= DOTS_TO_WIN - ALERT_LEVEL) {
                    for (int m = DOTS_TO_WIN - 1; m >= 0; m--) {
                        if (turn[m][2] == 2) {
                            break;
                        } else if (turn[m][2] == 0) {
                            map[turn[m][0]][turn[m][1]] = DOT_O;
                            System.out.println("RAКомпьютер походил в точку " + (turn[m][1] + 1) + " " + (turn[m][0] + 1));
                            turnDone = true;
                            break;
                        }
                    }
                }
                if (turnDone) break;
            }
            if (turnDone) break;
        }
        return turnDone;
    }
    private static boolean aiFinalize(){
        return false;
    }
}
