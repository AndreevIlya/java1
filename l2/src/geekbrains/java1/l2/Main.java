package geekbrains.java1.l2;

public class Main {

    public static void main(String[] args) {
        int[] c = arrayTest();
        System.out.println(c[0]);
    }
    public static int[] arrayTest(){
        int[][] a = {{1,2},{3,4}};
        return a[1];
    }
}
