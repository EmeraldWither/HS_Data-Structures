package org.emeraldcraft.datastructures;

import java.util.Iterator;
import java.util.TreeSet;

public class SetIntersectionUnion {
    public static void main(String[] args) {
        TreeSet<Integer> ints1 = new TreeSet<>();
        ints1.add(1);
        ints1.add(2);
        ints1.add(3);
        ints1.add(4);
        ints1.add(5);
        TreeSet<Integer> ints2 = new TreeSet<>();
        ints2.add(2);
        ints2.add(3);
        ints2.add(-2);
        ints2.add(1);
        ints2.add(7);
        System.out.println("Using ITR:");
        System.out.println("Set 1: " + ints1 + " | Set 2: " + ints2);
        System.out.println("Union: " + unionItr(ints1, ints2));
        System.out.println("Intersection: " + intersectionItr(ints1, ints2));

        System.out.println("\n\nNO ITR:");
        System.out.println("Set 1: " + ints1 + " | Set 2: " + ints2);
        System.out.println("Union: " + union(ints1, ints2));
        System.out.println("Intersection: " + intersection(ints1, ints2));

    }

    public static TreeSet<Integer> unionItr(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> union = new TreeSet<>();
        Iterator<Integer> itr1 = set1.iterator();
        Iterator<Integer> itr2 = set2.iterator();
        while(itr1.hasNext()) union.add(itr1.next());
        while(itr2.hasNext()) union.add(itr2.next());
        return union;
    }
    public static TreeSet<Integer> intersectionItr(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> intersection = new TreeSet<>();
        Iterator<Integer> itr1 = set1.iterator();
        while(itr1.hasNext()) {
            int next = itr1.next();
            if(set2.contains(next)) intersection.add(next);
        }
        return intersection;
    }
    public static TreeSet<Integer> intersection(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> intersection = new TreeSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);
        return intersection;
    }
    public static TreeSet<Integer> union(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> union = new TreeSet<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }
}
