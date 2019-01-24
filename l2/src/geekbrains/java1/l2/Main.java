package geekbrains.java1.l2;

public class Main {

    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        int[] array1 = {1,1,1,0,0,1,0,1,0,0,1,0};
        arrayShow(array1);
        arrayShow(zeroToOne(array1));
        System.out.print("\n");

        
    }
    public static void arrayShow(int[] a){
        for (int i=0; i < a.length; i++){
            if (i == 0) System.out.print(a[i]);
            else System.out.print(", " + a[i]);
        }
        System.out.print("\n");
    }
    public static int[] zeroToOne(int[] a){
        for (int i=0; i < a.length; i++){
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

}
