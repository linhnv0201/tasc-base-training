package collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMethods {
  public static void main(String[] args) {
    Set<String> set = new LinkedHashSet<>();

    // Thêm phần tử
    set.add("Apple");
    set.add("Banana");
    set.add("Orange");
    set.add("Banana"); // duplicate, bỏ qua

    // Duyệt phần tử (giữ thứ tự chèn)
    for (String s : set) {
      System.out.print(s + " ");
    }
    System.out.println();

    // Kiểm tra
    System.out.println("Contains Apple? " + set.contains("Apple"));

    // Xóa phần tử
    set.remove("Banana");
    System.out.println("After remove: " + set);

    // Kích thước
    System.out.println("Size: " + set.size());

    System.out.println(set.iterator()); // in ra Iterator<String> it = set.iterator();
    Iterator<String> it = set.iterator();
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }


    // Clear
    set.clear();
    System.out.println("Empty? " + set.isEmpty());
  }
}
