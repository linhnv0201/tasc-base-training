package collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(1);
        pq.add(3);

        System.out.println("PriorityQueue elements (natural order):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
