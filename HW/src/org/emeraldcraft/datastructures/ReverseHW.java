package org.emeraldcraft.datastructures;

public class ReverseHW {
    public static void main(String[] args) {
        System.out.println(reverse(929));
    }

    public static int reverse(int i) {
        if(i <= 9) return i;
        int b = i % 10;
        int itr = 0;
        for (int j = i; j >= 9; j/=10) itr++;
        return b * (10 * itr) + reverse(i / 10);
    }
}
