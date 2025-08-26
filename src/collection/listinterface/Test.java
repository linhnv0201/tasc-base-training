package collection.listinterface;

import java.util.Vector;

public class Test {
  public static void main(String[] args) {
    // 1. Khởi tạo Vector
    Vector<Integer> vector = new Vector<>();

    // 2. Thêm phần tử
    vector.add(10);
    vector.add(20);
    vector.add(30);

    System.out.println(vector.remove(1));
    System.out.println("Vector ban đầu: " + vector); // [10, 20, 30]


  }
}
