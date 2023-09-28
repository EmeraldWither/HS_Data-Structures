import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 4, 7, 9, 10, 11, 12 };
        System.out.println("Java API: " + Arrays.binarySearch(arr, 8));
        System.out.println("My Search: ");
        System.out.println("\t" + search(arr, 4));
        System.out.println("\t" + search(arr,8));
    }

    public static int search(int[] arr, int value) {
        return search(arr, 0, arr.length - 1, value);
    }

    private static int search(int[] arr, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2; 
            if (arr[mid] == value)
                return mid;
            else if (arr[mid] < value) {
                return search(arr, mid + 1, high, value);
            } else {
                return search(arr, low, mid - 1, value);
            }
        } else
            return -low - 1;
    }
}
