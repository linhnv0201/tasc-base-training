package collection.set;

import java.util.TreeSet;

public class TreeSetDemo {
  public static void main(String[] args) {
    TreeSet<Integer> numbers = new TreeSet<>();
    numbers.add(5);
    numbers.add(2);
    numbers.add(4);
    numbers.add(8);
    numbers.add(1);
    numbers.add(10);
    numbers.add(5); // duplicate → bị bỏ

    System.out.println("TreeSet (tự sắp xếp tăng dần): " + numbers);
    System.out.println("TreeSet theo thứ tự giảm dần: " + numbers.descendingSet());
    System.out.println("Phần tử nhỏ nhất (first): " + numbers.first());
    System.out.println("Phần tử lớn nhất (last): " + numbers.last());

    // Các phương thức tìm phần tử gần với giá trị cho trước
    System.out.println("Ceiling(6) → phần tử nhỏ nhất >= 6: " + numbers.ceiling(6));
    System.out.println("Floor(6)   → phần tử lớn nhất <= 6: " + numbers.floor(6));
    System.out.println("Higher(5)  → phần tử nhỏ nhất > 5: " + numbers.higher(5));
    System.out.println("Lower(5)   → phần tử lớn nhất < 5: " + numbers.lower(5));

    // Các phương thức lấy tập con
    System.out.println("SubSet(1,10) → phần tử từ 1 (inclusive) đến 10 (exclusive): " + numbers.subSet(1, 10));
    System.out.println("HeadSet(5)   → phần tử < 5: " + numbers.headSet(5));
    System.out.println("TailSet(5)   → phần tử >= 5: " + numbers.tailSet(5));

    // Các phương thức lấy và xóa phần tử đầu/cuối
    System.out.println("PollFirst() → lấy và xóa phần tử nhỏ nhất: " + numbers.pollFirst());
    System.out.println("PollLast()  → lấy và xóa phần tử lớn nhất: " + numbers.pollLast());
    System.out.println("TreeSet sau khi pollFirst và pollLast: " + numbers);
  }
}
