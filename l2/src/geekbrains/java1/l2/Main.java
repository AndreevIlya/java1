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
            array4[array4.length - i -1][i] = 1;
        }
        for(int[] z : array4)arrayShow(z);
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

        //Task 6
        System.out.println("Task 6");
        int[] array6 = new int[20];
        for( int j =0; j < 20; j++) {
            for (int i = 0; i < array6.length; i++) {
                array6[i] = (int) (Math.random() * 20 - 10);
            }
            arrayShow(array6);
            boolean result = balance(array6);
            System.out.println("Attempt " + (j + 1) + ": " + result);
            if(result) break;
        }
        System.out.print("\n");

        //Task 7 Positive n means a[0] -> a[n]
        System.out.println("Task 7");
        int[] array7 = new int[20];
        int n = (int) (Math.random() * 200 - 100);
        for (int i = 0; i < array7.length; i++) {
            array7[i] = (int) (Math.random() * 20 - 10);
        }
        arrayShow(array7);
        System.out.println("n = " + n);
        arrayShow(slider(array7, n));
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
        for (int i = 0; i < a.length; i++) b[i] = a[i] > 0 ? -a[i] : a[i];
        int max = b[0];
        for(int z : b) if (z > max) max = z;
        for(int z : a) if (z > max) max = z;
        return max;
    }
    public static int findMin(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[i] < 0 ? -a[i] : a[i];
        int min = b[0];
        for(int z : b) if (z < min) min = z;
        for(int z : a) if (z < min) min = z;
        return min;
    }
    public static boolean balance(int[] a){
        int sumRight = 0,
            sumLeft = 0;
        for (int z : a) sumRight += z;
        for (int z : a) {
            sumRight -= z;
            sumLeft += z;
            System.out.println(sumLeft + " " + sumRight); //To check how it went
            if (sumLeft == sumRight) return true;
        }
        return false;
    }
    public static int[] slider(int[] a, int n){
        int length = a.length,
            half = length / 2;
        if (n > 0){
            while (n >= length) n -= length;
            System.out.println("Modified n = " + n);
            if (n == 0) return a;
            int inter;
            if (n <= half){
                System.out.println("Path 1"); //To indicate which path went the calculation
                for (int i = 0; i < n; i++){
                    inter = a[length - 1];
                    System.arraycopy(a,0,a,1,length - 1);
                    a[0] = inter;
                }
            }else{
                System.out.println("Path 2"); //To indicate which path went the calculation
                n -= length;
                for (int i = n; i < 0; i++){
                    inter = a[0];
                    System.arraycopy(a,1,a,0,length - 1);
                    a[length - 1] = inter;
                }
            }
        }else if (n < 0){
            while (-n >= length) n += length;
            System.out.println("Modified n = " + n);
            if (n == 0) return a;
            int inter;
            if (-n <= half){
                System.out.println("Path 3"); //To indicate which path went the calculation
                for (int i = 0; i < n; i--){
                    inter = a[0];
                    System.arraycopy(a,1,a,0,length - 1);
                    a[length - 1] = inter;
                }
            }else{
                System.out.println("Path 4"); //To indicate which path went the calculation
                n += length;
                for (int i = n; i > 0; i--){
                    inter = a[length - 1];
                    System.arraycopy(a,0,a,1,length - 1);
                    a[0] = inter;
                }
            }
        }
        return a;
    }
}
