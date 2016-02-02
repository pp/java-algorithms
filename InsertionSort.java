import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
           int x = a[i];
           int j = i - 1;
           while (j >= 0 && a[j] > x) {
               a[j+1] = a[j];
               j = j - 1;
           }
           a[j+1] = x;
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 11, 6, 9, 1, 4, 3};
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

}
