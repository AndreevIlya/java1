package geekbrains.java1.l1;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        //Task 2
        byte nByte = 26;
        short nShort = 260;
        int nInt = 262144;
        long nLong = 1099511627776L;
        float nFloat = 2.6f;
        double nDouble = 2.6d;
        char letter = 'Z';
        boolean bool = true;

        // Task 3
        System.out.println("Task 3");
        System.out.println(fourItemsProduct(nByte, nShort, nInt, nInt)); //Long does not suit here ;(

        //Task 4
        System.out.println("\nTask 4");
        System.out.println(betweenTenAndTwenty(6,12));
        System.out.println(betweenTenAndTwenty(14,28));
        System.out.println(betweenTenAndTwenty(19,1));

        //Task 5
        System.out.println("\nTask 5");
        positiveOrNegative(78);
        positiveOrNegative(-78);

        //Task 6
        System.out.println("\nTask 6");
        System.out.println(isNegative(78));
        System.out.println(isNegative(-78));

        //Task 7
        System.out.println("\nTask 7");
        hello("Илья");

        //Task 8
        System.out.println("\nTask 8");
        isLeapYear(2000);
        isLeapYear(1900);
        isLeapYear(1676);
        isLeapYear(1911);

        //Task 8 Second solution
        System.out.println("\nTask 8 Second solution");
        isLeapYear2(2000);
        isLeapYear2(1900);
        isLeapYear2(1676);
        isLeapYear2(1911);

        //Something for fun
        System.out.println("\nSomething for fun");
        smthForFun(2.6,5.2);

    }
    public static int fourItemsProduct(int a, int b, int c, int d){
        return a * (b + (c / d));
    }
    public static boolean betweenTenAndTwenty(int a, int b){
        int z = a + b;
        return z >= 10 && z <= 20;
    }
    public static void positiveOrNegative(int a){
        String answer = a >= 0 ? "Positive" : "Negative";
        System.out.println(answer);
    }
    public static boolean isNegative(int a){
        return a < 0;
    }
    public static void hello(String name){
        System.out.println("Привет, " + name);
    }
    public static void isLeapYear(int year){
        String answer;
        if (year % 400 == 0) answer = " is a leap year!";
        else{
            if (year % 100 == 0) answer = " is not a leap year!";
            else{
                if (year % 4 == 0) answer = " is a leap year!";
                else answer = " is not a leap year!";
            }
        }
        System.out.println(year + answer);
    }
    public static void isLeapYear2(int year){
        String answer =  year % 400 == 0 ? " is a leap year!" : year % 100 == 0 ? " is not a leap year!" : year % 4 == 0 ? " is a leap year!" : " is not a leap year!";
        System.out.println(year + answer);
    }
    public static void smthForFun(double a, double b){
        double c = a * b;

        System.out.println("Multiplication of " + a + " and " + b + " with doubles gives " + c);

        BigDecimal  aB = new BigDecimal(a);
        BigDecimal  bB = new BigDecimal(b);
        BigDecimal  cB = aB.multiply(bB);

        System.out.println("Multiplication of " + a + " and " + b + " with BigDecimals gives " + cB);
    }
}
