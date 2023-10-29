package org.emeraldcraft.datastructures;

public class ReverseHW {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int i) {
        int abs = Math.abs(i);
        if(abs <= 9) return i;
        int itr = 0;
        for (int j = abs; j > 9; j/=10) itr++;
        return (abs % 10 * (((int) Math.pow(10, itr))) + reverse(abs / 10)) * i / abs;
    }
}
