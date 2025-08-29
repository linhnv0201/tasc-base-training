package collection.map;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<Object, String> map = new WeakHashMap<>();

        Object key1 = new Object();
        Object key2 = new Object();

        map.put(key1, "Value1");
        map.put(key2, "Value2");

        System.out.println("Before GC: " + map);

        key1 = null; // loại bỏ tham chiếu mạnh tới key1

        System.gc(); // gọi garbage collector

        // Chờ một chút để GC chạy
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("After GC: " + map);
    }
}
