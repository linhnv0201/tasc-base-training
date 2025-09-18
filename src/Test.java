import java.util.*;

public class Test {
  //  public static String toString() {
  //    System.out.println("TEst toString called");
  //    return "";
  //  }
  //
  //  public static void main(String[] args) {
  //    System.out.println(toString());
  //  }

  //  public static void main(String[] args) {
  //      String x = "abc";
  //      String y = "abc";
  //      x.concat(y);
  //    System.out.println(x);
  //    //
  //  }
  //
  //  public static void main(String[] args) {
  //      try{
  //          throw new IOException("Hello");
  //      } catch (IOException | Exception e){
  //      System.out.println(e.getMessage());
  //      }
  //    //
  //  }
  //  public static void main(String[] args) {
  ////    char c = 65;
  ////      int x = 20*10-20;
  ////    System.out.println(x);
  ////    System.out.println(c);
  //    //
  //      Subclass s1 = new Subclass();
  //      s1.foo();
  //      Super s = new Subclass();
  //      s.foo();
  //
  //  }
  //
  //  class Super{
  //      private void foo(){
  //      System.out.println("super");
  //      }
  //  }
  //
  //  class Subclass extends Super{
  //      public void foo(){
  //      System.out.println("subclass");
  //      }
  //  }
  //  public static void main(String[] args) {
  //    Super s = new Subclass();
  //    s.foo();
  //  }
  //
  //  class Super {
  //    void foo() {
  //      System.out.println("super");
  //    }
  //  }
  //
  //  class Subclass extends Super {
  //    static void foo() {
  //      System.out.println("subclass");
  //    }
  //  }

  public static void main(String[] args) {
    int a = -8; // 11111111 11111111 11111111 11111000
    int b = a >>> 2; // 11111111 11111111 11111111 11111110
    System.out.println(b); // -2

    List<String> names = Arrays.asList("Linh", "Nam", "Hà", "An");

    // Lấy ra danh sách tên bắt đầu bằng "N", chuyển thành chữ hoa, sắp xếp và in ra
    names.stream()
        .filter(name -> name.startsWith("N"))
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);

    Map<String, Object> map = new HashMap<>();
    map.put("Linh", new Test());
    System.out.println(map);

    Set<String> role = new HashSet<>(Set.of("ADMIN", "USER"));
    System.out.println(role);
    }
}
