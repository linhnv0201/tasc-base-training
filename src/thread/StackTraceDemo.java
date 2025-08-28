package thread;

public class StackTraceDemo {
  static int devide(int a, int b) {
    return a / b;
  }

  public static void main(String[] args) {
    try{
      devide(10, 0); // divide(10,0) → ArithmeticException xảy ra.
    } catch (ArithmeticException e){ // Exception bị ném lên main, bắt trong try-catch.
      e.printStackTrace(); // e.printStackTrace() in ra toàn bộ call stack: (chương trình vẫn chạy tiếp)
                            // Dòng đầu: loại exception + message
                            // Dòng sau: từng method dẫn đến lỗi, từ divide() → main()
      System.out.println(e.getMessage());
    }
  }
}
