package collection.listinterface;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    // Khai báo kiểu List nhưng implement khác nhau
    List<String> arrayList = new ArrayList<>();
    List<String> linkedList = new LinkedList<>();

    // Thêm phần tử
    arrayList.add("A");
    arrayList.add("B");
    linkedList.add("X");
    linkedList.add("Y");

    // Truy cập phần tử
    System.out.println("ArrayList first: " + arrayList.get(0)); // A
    System.out.println("LinkedList first: " + linkedList.get(0)); // X

    // Xóa phần tử
    arrayList.remove("A");
    linkedList.remove("X");
    System.out.println("ArrayList after remove: " + arrayList); // [B]
    System.out.println("LinkedList after remove: " + linkedList); // [Y]

    // Chỉ dùng được các method của List
    // arrayList.trimToSize(); // ❌ Lỗi, biến kiểu List
    // linkedList.addFirst("Z"); // ❌ Lỗi, biến kiểu List

    // Nếu muốn dùng method riêng, phải ép kiểu
    ((ArrayList<String>) arrayList).trimToSize(); // ✅ ArrayList method
    ((LinkedList<String>) linkedList).addFirst("Z"); // ✅ LinkedList method

    try {
      ((LinkedList<String>) arrayList).addFirst("Z"); //Object thực tế là ArrayList, nên ép kiểu về LinkedList sẽ gây ClassCastException lúc runtime.
    } catch (ClassCastException e){
      System.out.println(e.getMessage());
    }
    System.out.println("LinkedList after addFirst: " + linkedList); // [Z, Y]
  }
}

