package collection.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDequeDemo {
    public static void main(String[] args) {
        // ================== Queue ==================
//        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Thêm phần tử
        queue.add(10);
        queue.add(20);
        queue.offer(30); // offer cũng thêm cuối
        System.out.println("Queue ban đầu: " + queue); // [10, 20, 30]

        // Lấy & xóa phần tử đầu
        System.out.println("poll(): " + queue.poll()); // 10
        System.out.println("Queue sau poll: " + queue); // [20, 30]

        // Lấy phần tử đầu nhưng không xóa
        System.out.println("peek(): " + queue.peek()); // 20

        // ================== Deque ==================
        Deque<Integer> deque = new ArrayDeque<>();

        // Thêm vào đầu/cuối
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(30);
        System.out.println("Deque ban đầu: " + deque); // [5, 10, 20, 30]

        // Lấy & xóa đầu/cuối
        System.out.println("pollFirst(): " + deque.pollFirst()); // 5
        System.out.println("pollLast(): " + deque.pollLast());   // 30
        System.out.println("Deque sau poll: " + deque);          // [10, 20]

        // Lấy phần tử đầu/cuối nhưng không xóa
        System.out.println("peekFirst(): " + deque.peekFirst()); // 10
        System.out.println("peek: " + deque.peek()); // 10
        System.out.println("peekLast(): " + deque.peekLast());   // 20
    }
}
