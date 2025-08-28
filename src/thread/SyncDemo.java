package thread;

public class SyncDemo {
  static void doWork() {
    // sleep() là phương thức “checked exception”
    try {
      Thread.sleep(5000); // giả lập công việc nặng trong 5s
      System.out.println("Xong việc!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("Bắt đầu");
    doWork();
    System.out.println("Kết thúc");
  }
}
