package collection.queue;
import java.util.*;

public class TestDeque {
    public static void main(String[] args) {
        // Tạo LinkedList và ArrayDeque
        Deque<String> linkedList = new LinkedList<>();
        Deque<String> arrayDeque = new ArrayDeque<>();

        // --- Thêm phần tử ---
        linkedList.add("A");       // thêm cuối
        linkedList.addFirst("B");  // thêm đầu
        linkedList.addLast("C");   // thêm cuối

        arrayDeque.add("A");
        arrayDeque.addFirst("B");
        arrayDeque.addLast("C");

        System.out.println("LinkedList: " + linkedList);   // [B, A, C]
        System.out.println("ArrayDeque: " + arrayDeque);   // [B, A, C]

        // --- Lấy phần tử ---
        System.out.println("\nLấy đầu & cuối:");
        System.out.println("LinkedList getFirst(): " + linkedList.getFirst());   // B
        System.out.println("ArrayDeque getFirst(): " + arrayDeque.getFirst());   // B
        System.out.println("LinkedList getLast(): " + linkedList.getLast());     // C
        System.out.println("ArrayDeque getLast(): " + arrayDeque.getLast());     // C

        // --- Xóa phần tử ---
        linkedList.removeFirst();
        arrayDeque.removeFirst();
        System.out.println("\nSau khi removeFirst():");
        System.out.println("LinkedList: " + linkedList);   // [A, C]
        System.out.println("ArrayDeque: " + arrayDeque);   // [A, C]

        // --- Điểm khác biệt: LinkedList cho phép truy cập index ---
        System.out.println("\nTruy cập bằng index:");
        System.out.println("LinkedList.get(1): " + ((LinkedList<String>)linkedList).get(1)); // C
        // ArrayDeque không có get(index), chỉ duyệt tuần tự
        System.out.println("ArrayDeque (duyệt): ");
        for (String s : arrayDeque) {
            System.out.print(s + " ");
        }
    }
}

