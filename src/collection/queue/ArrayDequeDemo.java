package collection.queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();

        // Khách đến gọi taxi
        queue.addLast("Alice");
        queue.addLast("Bob");
        queue.addLast("Charlie");

        System.out.println("Danh sách khách trong hàng chờ: " + queue);

        // Từng khách được phục vụ (FIFO)
        System.out.println("Phục vụ khách: " + queue.pollFirst()); // Alice
        System.out.println("Phục vụ khách: " + queue.pollFirst()); // Bob

        System.out.println("Hàng chờ còn lại: " + queue);
    }
}
