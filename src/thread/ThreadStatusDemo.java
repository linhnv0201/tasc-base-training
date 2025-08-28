import java.util.concurrent.*;

public class ThreadStatusDemo {

  // Thread kế thừa Thread
  static class MyThread extends Thread {
    private String name;
    public MyThread(String name) { this.name = name; }

    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {}
      System.out.println(name + " đã hoàn thành");
    }
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    System.out.println("=== Dùng isAlive() ===");
    Thread t1 = new MyThread("Thread-1");
    Thread t2 = new MyThread("Thread-2");
    t1.start();
    t2.start();

    while (t1.isAlive() || t2.isAlive()) {
      System.out.println("Chờ thread kết thúc...");
      Thread.sleep(200);
    }
    System.out.println("Tất cả thread đã xong (isAlive check)\n");

    System.out.println("=== Dùng join() ===");
    Thread t3 = new MyThread("Thread-3");
    Thread t4 = new MyThread("Thread-4");
    t3.start();
    t4.start();
    t3.join(); // chờ t3 xong
    t4.join(); // chờ t4 xong
    System.out.println("Tất cả thread đã xong (join)\n");

    System.out.println("=== Dùng ExecutorService + Future ===");
    ExecutorService executor = Executors.newFixedThreadPool(2);

    Callable<String> task1 = () -> {
      Thread.sleep(1000);
      return "Task-1 done";
    };
    Callable<String> task2 = () -> {
      Thread.sleep(1500);
      return "Task-2 done";
    };

    Future<String> f1 = executor.submit(task1);
    Future<String> f2 = executor.submit(task2);

    while (!f1.isDone() || !f2.isDone()) {
      System.out.println("Chờ task hoàn thành...");
      Thread.sleep(200);
    }

    System.out.println(f1.get());
    System.out.println(f2.get());

    executor.shutdown();
  }
}
