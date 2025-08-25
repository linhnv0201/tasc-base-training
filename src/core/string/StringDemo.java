package core.string;

public class StringDemo {
  public static void main(String[] args) {
    // Tạo String
    String s1 = "Hello";
    String s2 = "Hello";
    String s3 = new String("Hello");

    // So sánh tham chiếu
    System.out.println("s1 == s2: " + (s1 == s2)); // true (cùng pool)
    System.out.println("s1 == s3: " + (s1 == s3)); // false (heap khác)

    // So sánh nội dung
    System.out.println("s1.equals(s3): " + s1.equals(s3)); // true

    // So sánh thứ tự từ điển
    String a = "Apple";
    String b = "Banana";
    System.out.println("a.compareTo(b): " + a.compareTo(b)); // < 0 (Apple < Banana)

    // Demo bất biến
    String str = "Java";
    str.concat(" World"); // tạo chuỗi mới nhưng không gán lại
    System.out.println("str: " + str); // "Java"

    str = str.concat(" World"); // gán lại biến
    System.out.println("str sau concat: " + str); // "Java World"
  }
}
