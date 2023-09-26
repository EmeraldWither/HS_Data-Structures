import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        while (!isSorted(a)) {
            for (int i = 1; i < a.length; i++) {
                if(a[i - 1] > a[i]) {
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
}
