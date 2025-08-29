package collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
  public static void main(String[] args) {
    HashSet<Integer> numbers = new HashSet<>();
    numbers.add(5);
    numbers.add(2);
    numbers.add(4);
    numbers.add(8);
    numbers.add(1);
    numbers.add(10);
    numbers.add(5); // duplicate → bị bỏ

    System.out.println("HashSet (không theo thứ tự): " + numbers);

    // Kiểm tra phần tử có tồn tại trong set
    System.out.println("Contains 5? " + numbers.contains(5));
    System.out.println("Contains 7? " + numbers.contains(7));

    // Xóa phần tử
    System.out.println("Xóa dc ko " + numbers.remove(100));
    System.out.println("Sau khi remove 2: " + numbers);

    // Duyệt HashSet bằng iterator
    System.out.print("Duyệt các phần tử bằng iterator: ");
    Iterator<Integer> it = numbers.iterator();
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();

    // Kích thước HashSet
    System.out.println("Kích thước hiện tại: " + numbers.size());

    // Xóa toàn bộ
    numbers.clear();
    System.out.println("Sau khi clear: " + numbers);
  }
}
