package collection.listinterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int n = 1_000_00;

        // ================== Test ArrayList ==================
        List<Integer> arrayList = new ArrayList<>();

        // Thêm cuối
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList - thêm cuối: " + (end - start)/1_000_000.0 + " ms");

        // Thêm đầu
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i); // chèn ở đầu
        }
        end = System.nanoTime();
        System.out.println("ArrayList - thêm đầu (1000 lần): " + (end - start)/1_000_000.0 + " ms");

        // Truy cập giữa
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = arrayList.get(n / 2);
        }
        end = System.nanoTime();
        System.out.println("ArrayList - truy cập giữa (1000 lần): " + (end - start)/1_000_000.0 + " ms");


        // ================== Test LinkedList ==================
        List<Integer> linkedList = new LinkedList<>();

        // Thêm cuối
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList - thêm cuối: " + (end - start)/1_000_000.0 + " ms");

        // Thêm đầu
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i); // chèn ở đầu
        }
        end = System.nanoTime();
        System.out.println("LinkedList - thêm đầu (1000 lần): " + (end - start)/1_000_000.0 + " ms");

        // Thêm giữa
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i/2, i); // chèn ở đầu
        }
        end = System.nanoTime();
        System.out.println("LinkedList - thêm giữa (1000 lần): " + (end - start)/1_000_000.0 + " ms");

        // Truy cập giữa
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = linkedList.get(n / 2);
        }
        end = System.nanoTime();
        System.out.println("LinkedList - truy cập giữa (1000 lần): " + (end - start)/1_000_000.0 + " ms");
    }
}

