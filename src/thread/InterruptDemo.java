package thread;

// Trạng thái thread khi gọi interrupt()	Hành vi
// Sleep / Wait / Join	Ném InterruptedException ngay, flag reset về false
// Chạy bình thường	Không ném exception, flag interrupted = true, thread tự kiểm tra
public class InterruptDemo {
  public static void main(String[] args) {
    Thread t =
        new Thread(
            () -> {
              try {
                System.out.println("Thread ngủ 5s...");
                Thread.sleep(10000);
                System.out.println("Dậy rồi!");
              } catch (InterruptedException e) {
                System.out.println("Thread bị đánh thức sớm!");
              }
              System.out.println("Thread done"); // neu catch interrupt thi day luon sau 5s, kiểu bị đánh thức sớm.
            });

    t.start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t.interrupt(); // Đánh thức thread kia
  }
}
