package collection.listinterface;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 1. Khởi tạo ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // 2. Thêm phần tử vào cuối
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Ban đầu: " + list); // [10, 20, 30]

        // 3. Thêm vào vị trí cụ thể (chèn vào đầu)
        try {
        list.add(10, 5);
        } catch (IndexOutOfBoundsException exception){
            System.out.println("--------------------"+ exception);
        }
        System.out.println("Thêm 5 vào đầu: " + list); // [5, 10, 20, 30]

        // 4. Thêm vào cuối (giống add bình thường)
        list.add(list.size(), 40);
        System.out.println("Thêm vào cuối: " + list); // [5, 10, 20, 30, 40]

        // 5. Chèn vào giữa (index = 2)
        list.add(2, 15);
        System.out.println("Chèn 15 vào index 2: " + list); // [5, 10, 15, 20, 30, 40]

        // 7. Cập nhật phần tử
        list.set(3, 25); // thay 20 -> 25
        System.out.println("Sau khi cập nhật index 3 = 25: " + list); // [5, 10, 15, 25, 30, 40]

        // 8. Xóa phần tử đầu, cuối, giữa
        list.remove(0); // xóa đầu
        System.out.println("Sau khi xóa đầu: " + list); // [10, 15, 25, 30, 40]

        list.remove(list.size() - 1); // xóa cuối
        System.out.println("Sau khi xóa cuối: " + list); // [10, 15, 25, 30]

        list.remove(1); // xóa tại index 1
        System.out.println("Sau khi xóa tại index 1: " + list); // [10, 25, 30]

        // 9. Duyệt ArrayList
        System.out.print("Duyệt danh sách: ");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ❌ KHÔNG có poll() hay peek() như LinkedList
        // Muốn giả lập "peek" -> dùng get(0)
        if (!list.isEmpty()) {
            System.out.println("peek() giả lập -> " + list.get(0)); // lấy phần tử đầu
        }

        // Muốn giả lập "poll" -> lấy và remove(0)
        if (!list.isEmpty()) {
            Integer polled = list.remove(0);
            System.out.println("poll() giả lập -> " + polled);
            System.out.println("Danh sách sau poll giả lập: " + list);
        }
    }
}
