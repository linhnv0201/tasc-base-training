package collection.listinterface;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // 1. Khởi tạo LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // 2. Thêm phần tử vào cuối
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Ban đầu: " + list); // [10, 20, 30]

        // 3. Thêm vào đầu
        list.addFirst(5);
        System.out.println("Thêm vào đầu: " + list); // [5, 10, 20, 30]

        // 4. Thêm vào cuối
        list.addLast(40);
        System.out.println("Thêm vào cuối: " + list); // [5, 10, 20, 30, 40]

        // 5. Chèn vào giữa (index = 2)
        list.add(2, 15);
        System.out.println("Chèn 15 vào index 2: " + list); // [5, 10, 15, 20, 30, 40]


        // 7. Cập nhật phần tử
        list.set(3, 25); // thay 20 -> 25
        System.out.println("Sau khi cập nhật index 3 = 25: " + list); // [5, 10, 15, 25, 30, 40]

        // 8. Xóa phần tử đầu, cuối, giữa
        list.removeFirst(); // xóa đầu
        System.out.println("Sau khi xóa đầu: " + list); // [10, 15, 25, 30, 40]

        list.removeLast(); // xóa cuối
        System.out.println("Sau khi xóa cuối: " + list); // [10, 15, 25, 30]

        list.remove(1); // xóa tại index 1
        System.out.println("Sau khi xóa tại index 1: " + list); // [10, 25, 30]

        // 9. Duyệt LinkedList
        System.out.print("Duyệt danh sách: ");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 10. Queue operations: poll, peek
        System.out.println("peek() -> " + list.peek()); // lấy đầu (10), không xóa
        System.out.println("poll() -> " + list.poll()); // lấy đầu (10) và xóa
        System.out.println("Danh sách sau poll: " + list); // [25, 30]

        // 11. Thử peekFirst, peekLast, pollFirst, pollLast
        System.out.println("peekFirst() -> " + list.peekFirst()); // 25
        System.out.println("peekLast() -> " + list.peekLast());   // 30

        System.out.println("pollFirst() -> " + list.pollFirst()); // 25
        System.out.println("pollLast() -> " + list.pollLast());   // 30

        System.out.println("Danh sách cuối cùng: " + list); // []
    }
}
