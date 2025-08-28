package collection.listinterface;

import java.util.*;

public class Compare {
  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    for (int i = 0; i < 1_000_0000; i++) {
      arr.add(i);
      linked.add(i);
    }

    long t1 = System.nanoTime();
    arr.get(500_0000);
    long t2 = System.nanoTime();
    linked.get(1000000);
    long t3 = System.nanoTime();

    System.out.println("ArrayList get: " + (t2 - t1)  + "ns");
    System.out.println("LinkedList get: " + (t3 - t2)  + "ns");
  }
}
