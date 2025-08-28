package thread;

public class AsyncDemo {

  static void doWork() {
    try {
      Thread.sleep(5000); // giả lập công việc nặng trong 5s
      System.out.println("Xong việc!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    System.out.println("Bắt đầu");

    new Thread(() -> doWork()).start();

    System.out.println("Kết thúc (không cần đợi)");
  }
}
