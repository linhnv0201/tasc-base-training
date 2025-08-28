package thread;

public class InterruptDemo {
  public static void main(String[] args) {
    Thread t =
        new Thread(
            () -> {
              try {
                System.out.println("Thread ngủ 5s...");
                Thread.sleep(5000);
                System.out.println("Dậy rồi!");
              } catch (InterruptedException e) {
                System.out.println("Thread bị đánh thức sớm!");
              }
            });

    t.start();

    try {
      Thread.sleep(2000); // main chờ 2s
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    t.interrupt(); // Đánh thức thread kia
  }
}
