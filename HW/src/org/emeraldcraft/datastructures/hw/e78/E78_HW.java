package org.emeraldcraft.datastructures.hw.e78;

import java.util.Arrays;
import java.util.Random;

public class E78_HW {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(arr1));
        int[] permutation = new int[10];
        for (int i = 0; i < 10; i++) {
            int index = 0;
            do {
                index = new Random().nextInt(10);
            } while (arr1[index] == 0);
            permutation[i] = arr1[index];
            arr1[index] = 0;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(permutation));
    }
}
