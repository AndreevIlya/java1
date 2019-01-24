package geekbrains.java1.l2;

public class Main {

    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        int[] array1 = {1,1,1,0,0,1,0,1,0,0,1,0};
        arrayShow(array1);
        arrayShow(zeroToOne(array1));
        System.out.print("\n");

        //Task 2
        System.out.println("Task 2");
        int[] array2 = new int[8];
        array2[0] = 0;
        for (int i = 1; i < 8; i++){
            array2[i] = array2[i-1] + 3;
        }
        arrayShow(array2);
        System.out.print("\n");

        //Task 3
        System.out.println("Task 3");
        int[] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < array3.length; i++){
            if (array3[i] < 6) array3[i] *= 2;
        }
        arrayShow(array3);
        System.out.print("\n");

        //Task 4
        System.out.println("Task 4");
        int[][] array4 = new int[10][10];
        for (int i = 0; i < array4.length; i++){
            array4[i][i] = 1;
        }
        for (int i = 0; i < array4.length; i++){
            arrayShow(array4[i]);
        }
        System.out.print("\n");

        //Task 5
        System.out.println("Task 5");
        int[] array5 = new int[20];
        for (int i = 0; i < array5.length; i++){
            array5[i]= (int) (Math.random() * 20000 - 10000);
        }
        arrayShow(array5);
        System.out.println("Max: " + findMax(array5));
        System.out.println("Min: " + findMin(array5));
        System.out.print("\n");
    }
    public static void arrayShow(int[] a){
        for (int i = 0; i < a.length; i++){
            if (i == 0) System.out.print(a[i]);
            else System.out.print(", " + a[i]);
        }
        System.out.print("\n");
    }
    public static int[] zeroToOne(int[] a){
        for (int i = 0; i < a.length; i++){
            switch (a[i]){
                case 0:{
                    a[i] = 1;
                    break;
                }case 1:{
                    a[i] = 0;
                    break;
                }
            }
        }
        return a;
    }
    public static int findMax(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++){
            if (a[i] > 0) b[i] = -a[i];
            else b[i] = a[i];
        }
        int max = b[0];
        for (int i = 1; i < a.length; i++){
            if (b[i] > max) max = b[i];
        }
        for (int i = 1; i < a.length; i++){
            if (a[i] > max) max = a[i];
        }
        return max;
    }
    public static int findMin(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0) b[i] = -a[i];
            else b[i] = a[i];
        }
        int min = b[0];
        for (int i = 1; i < a.length; i++){
            if (b[i] < min) min = b[i];
        }
        for (int i = 1; i < a.length; i++){
            if (a[i] < min) min = a[i];
        }
        return min;
    }
}
