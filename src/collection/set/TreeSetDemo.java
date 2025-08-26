package collection.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
  public static void main(String[] args) {
//    Set<Integer> numbers = new TreeSet<>(); khai báo này ko dùng dc descendingSet
    TreeSet<Integer> numbers = new TreeSet<>();
//    Set<Integer> numbers = new TreeSet<>(Comparator.reverseOrder()); // nếu muốn sắp giảm dần
    numbers.add(5);
    numbers.add(1);
    numbers.add(10);
    numbers.add(5); // duplicate, bị bỏ

    System.out.println(numbers); // [1, 5, 10] → tự sắp xếp
    System.out.println(numbers.descendingSet());
    System.out.println("First: " + ((TreeSet<Integer>) numbers).first());
    System.out.println("Last: " + ((TreeSet<Integer>) numbers).last());
  }
}
