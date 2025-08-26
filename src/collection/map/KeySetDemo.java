package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 20);

        // Lấy tập hợp key
        Set<String> keys = map.keySet();

        // Duyệt key và lấy value
        for (String key : keys) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Xóa key thông qua keySet
        keys.remove("Bob");
        System.out.println("Map sau khi remove Bob: " + map);
    }
}
