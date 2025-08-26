package collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetPerformanceDemo {
  public static void main(String[] args) {
    int n = 1_000_000;

    // ================= HashSet =================
    Set<Integer> hashSet = new HashSet<>();
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) hashSet.add(i);
    long end = System.currentTimeMillis();

    System.out.println("HashSet add: " + (end - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) hashSet.remove(i);
    end = System.currentTimeMillis();
    System.out.println("HashSet remove: " + (end - start) + " ms");

    // ================= LinkedHashSet =================
    Set<Integer> linkedHashSet = new LinkedHashSet<>();
    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) linkedHashSet.add(i);
    end = System.currentTimeMillis();
    System.out.println("LinkedHashSet add: " + (end - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) linkedHashSet.remove(i);
    end = System.currentTimeMillis();
    System.out.println("LinkedHashSet remove: " + (end - start) + " ms");

    // ================= TreeSet =================
    Set<Integer> treeSet = new TreeSet<>();
    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) treeSet.add(i);
    end = System.currentTimeMillis();
    System.out.println("TreeSet add: " + (end - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) treeSet.remove(i);
    end = System.currentTimeMillis();
    System.out.println("TreeSet remove: " + (end - start) + " ms");
  }
}
