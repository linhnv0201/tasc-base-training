package core.string;

public class StringMethodsDemo {
  public static void main(String[] args) {
    String s = "  Hello Java World  ";

    // 1. length()
    System.out.println("Length: " + s.length()); // 19

    // 2. charAt()
    System.out.println("charAt(2): " + s.charAt(2)); // 'H'

    // 3. substring()
    System.out.println("substring(2, 7): " + s.substring(2, 7)); // Hello

    // 4. toUpperCase() & toLowerCase()
    System.out.println("toUpperCase: " + s.toUpperCase()); //   HELLO JAVA WORLD
    System.out.println("toLowerCase: " + s.toLowerCase()); //   hello java world

    // 5. trim()
    //    Trả về một chuỗi mới (vì String bất biến – immutable).
    //            Xóa khoảng trắng ở đầu và cuối chuỗi.
    //            Không xóa khoảng trắng ở giữa chuỗi.
    System.out.println("trim: '" + s.trim() + "'"); // "Hello Java World"

    // 6. indexOf() & lastIndexOf()
    System.out.println("indexOf('Java'): " + s.indexOf("Java")); // 8
    System.out.println("firstIndexOf('o'): " + s.indexOf("o")); //
    System.out.println("lastIndexOf('o'): " + s.lastIndexOf("o")); // 14

    // 7. replace()
    System.out.println("replace: " + s.replace("Java", "C++")); //   Hello C++ World

    // 8. split()
    String[] words = s.trim().split(" ");
    System.out.println("split:");
    for (String w : words) {
      System.out.println(" - " + w);
    }

    // 9. equals() & equalsIgnoreCase()
    String a = "Java";
    String b = "java";
    System.out.println("equals: " + a.equals(b)); // false
    System.out.println("equalsIgnoreCase: " + a.equalsIgnoreCase(b)); // true

    // 10. compareTo()
    System.out.println("compareTo (Java vs Apple): " + "Java".compareTo("Apple")); // > 0
    System.out.println("compareTo (Apple vs Java): " + "Apple".compareTo("Java")); // < 0
    System.out.println("compareTo (Java vs Java): " + "Java".compareTo("Java")); // 0

    // 11. contains()
    System.out.println("contains 'World': " + s.contains("World")); // true

    // 12. startsWith() & endsWith()
    System.out.println("startsWith '  He': " + s.startsWith("  He")); // true
    System.out.println("endsWith 'ld  ': " + s.endsWith("ld  ")); // true
  }
}
