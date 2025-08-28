package thread;

public class ThreadStatusDemo {
  static class MyThread extends Thread {
    boolean finished = false;

    MyThread(String name) {
      super(name);
    }

    @Override
    public void run() {
      System.out.println(getName() + " bắt đầu");
      try {
        Thread.sleep(2000); // giả lập công việc
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      finished = true; // cập nhật flag khi kết thúc
      System.out.println(getName() + " kết thúc");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread("Thread-1");
    MyThread t2 = new MyThread("Thread-2");

    t1.start();
    t2.start();

    // 1️⃣ Dùng isAlive()
    while (t1.isAlive() || t2.isAlive()) {
      System.out.println("Đang chờ thread hoàn thành...");
      Thread.sleep(500);
    }
    System.out.println("isAlive: Cả 2 thread đã kết thúc");

    // 2️⃣ Dùng join()
    MyThread t3 = new MyThread("Thread-3");
    t3.start();
    t3.join(); // main chờ t3 xong
    System.out.println("join: Thread-3 chắc chắn đã kết thúc");

    // 3️⃣ Dùng biến cờ
    MyThread t4 = new MyThread("Thread-4");
    t4.start();
    while (!t4.finished) {
      System.out.println("flag: Thread-4 vẫn đang chạy...");
      Thread.sleep(500);
    }
    System.out.println("flag: Thread-4 đã xong");
  }
}
