package collection.listinterface;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // 1. Khởi tạo Vector
        Vector<Integer> vector = new Vector<>();

        // 2. Thêm phần tử
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println("Vector ban đầu: " + vector); // [10, 20, 30]

        // 3. Chèn vào vị trí cụ thể
        vector.add(1, 15);
        System.out.println("Sau khi chèn 15 vào index 1: " + vector); // [10, 15, 20, 30]

        // 4. Cập nhật phần tử
        vector.set(2, 25); // thay 20 -> 25
        System.out.println("Sau khi cập nhật index 2 = 25: " + vector); // [10, 15, 25, 30]

        // 5. Xóa phần tử
        vector.remove(0); // xóa đầu
        System.out.println("Sau khi xóa index 0: " + vector); // [15, 25, 30]

        vector.remove(Integer.valueOf(25)); // xóa theo giá trị
        System.out.println("Sau khi xóa 25: " + vector); // [15, 30]

        // 6. Lấy phần tử đầu/cuối
        System.out.println("Phần tử đầu: " + vector.firstElement()); // 15
        System.out.println("Phần tử cuối: " + vector.lastElement()); // 30

        // 7. Duyệt Vector
        System.out.print("Duyệt Vector: ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 8. Kiểm tra size và contains
        System.out.println("Kích thước: " + vector.size()); // 2
        System.out.println("Có chứa 30? " + vector.contains(30)); // true
    }
}

