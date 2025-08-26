package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1️⃣ Khởi tạo HashMap
        Map<String, Integer> map = new HashMap<>();

        // 2️⃣ Thêm / Cập nhật
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 20);
        map.putIfAbsent("David", 40);  // thêm nếu chưa tồn tại
        map.put("Alice", 35);           // cập nhật value của Alice

        System.out.println("Map sau khi thêm/cập nhật: " + map);

        // 3️⃣ Lấy giá trị
        System.out.println("Age của Alice: " + map.get("Alice"));
        System.out.println("Age của Eve (mặc định 0): " + map.getOrDefault("Eve", 0));

        // 4️⃣ Kiểm tra tồn tại
        System.out.println("Có key 'Bob'? " + map.containsKey("Bob"));
        System.out.println("Có value 25? " + map.containsValue(25));

        // 5️⃣ Xóa
        map.remove("Charlie");
        map.remove("David", 40);   // xóa nếu key+value khớp
        System.out.println("Map sau khi xóa: " + map);

        // 6️⃣ Kích thước / rỗng
        System.out.println("Kích thước map: " + map.size());
        System.out.println("Map rỗng? " + map.isEmpty());

        // 7️⃣ Duyệt Map
        System.out.println("\nDuyệt bằng keySet:");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("\nDuyệt bằng entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nDuyệt bằng Iterator:");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 8️⃣ Các lệnh hữu ích khác
        map.replace("Alice", 36);                 // thay giá trị
        map.merge("Bob", 5, (oldVal, newVal) -> oldVal + newVal); // gộp value
        System.out.println("\nMap sau replace/merge: " + map);
    }
}
