package thread;

public class JoinDemo {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            () -> {
              System.out.println("Thread-1 bắt đầu");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {
              }
              System.out.println("Thread-1 kết thúc");
            });

    Thread t2 =
        new Thread(() -> {
              System.out.println("Thread-2 bắt đầu");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {}
              System.out.println("Thread-2 kết thúc");
            });

    Thread t3 =
        new Thread(() -> {
              System.out.println("Thread-3 bắt đầu");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {}
              System.out.println("Thread-3 kết thúc");
            });

    // Bắt đầu thread lần lượt và chờ thread trước kết thúc
    t1.start();
    t1.join(10000); // main chờ t1 xong,

    t2.start();
    t2.join(); // main chờ t2 xong
//    System.out.println(t2.isInterrupted());
//    boolean check = t1.isAlive();
//    System.out.println("t1 is running (" + check + "). state = "+ t1.getState());

//    System.out.println("t3 state = " + t3.getState());
    t3.start();
    t3.join(); // main chờ t3 xong

    System.out.println("Tất cả thread đã hoàn thành");
  }
}
