package collection.listinterface;

import java.util.LinkedList;
import java.util.List;

public class DemoListVsLinkedList {
    public static void main(String[] args) {
        // Khai báo cụ thể bằng LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20); // ~ addLast
        list.addFirst(5);   // ✅ Dùng được vì đây là phương thức riêng của LinkedList
        list.addLast(30);   // ✅ Dùng được
        System.out.println("LinkedList cụ thể: " + list);

        // Khai báo bằng interface List
        List<Integer> list1 = new LinkedList<>();
        list1.add(100);
        list1.add(200);
        list1.add(1, 150);  // ✅ Vẫn chèn được nhờ hàm của List
        System.out.println("List (interface): " + list1);

        // ❌ Không thể gọi phương thức đặc thù của LinkedList qua List
        // list1.addFirst(50); // Lỗi compile! Vì List không có addFirst
        // list1.getLast();    // Lỗi compile! Vì List không có getLast

        list.addAll(2, list1); // chèn all list1 vào vị trí thứ 2 trong list
        System.out.println("LinkedList cụ thể: " + list);
    }
}

