package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.time.Year;

public class Test {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Alice", 30);
    map.put("Bob", 25);
    map.put("Charlie", 20);

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String name = entry.getKey();
      int age = entry.getValue();
      System.out.println(name + " năm nay " + age);
    }
  }
}
