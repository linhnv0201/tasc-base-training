package core.exception;

public class DemoUncheckedException {

  // Unchecked Exception: không cần khai báo throws
  static void divide(int a, int b) {
    int result = a / b; // ArithmeticException nếu b = 0
    System.out.println("Division result: " + result);
  }

  public static void main(String[] args) {
    try {
      divide(10, 2); // hợp lệ
      divide(10, 0); // chia cho 0 → ném ArithmeticException
    } catch (ArithmeticException e) {
      System.out.println("Caught Unchecked Exception: " + e.getMessage());
      System.out.println(e);
    }
//    divide(10, 2); // hợp lệ
//    divide(10, 0); // chia cho 0 → ném ArithmeticException

    System.out.println("Program continues...");
  }
}
