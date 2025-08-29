package thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    for (int i = 1; i <= 5; i++) {
      int taskId = 1;
      //      executorService.submit(
      //          () -> {
      //            System.out.println(
      //                "Task " + taskId + " đang chạy bởi " + Thread.currentThread().getName());
      //            try {
      //              Thread.sleep(3000);
      //            } catch (InterruptedException e) {
      //            }
      //            System.out.println(
      //                "Task " + taskId + " kết thúc bởi " + Thread.currentThread().getName());
      //          });
      executorService.execute(
              () -> {
                System.out.println(
                    "Task " + taskId + "is running at " + Thread.currentThread().getName());
                try {
                  Thread.sleep(3000);
                } catch (InterruptedException ignored) {}
                System.out.println(
                    "Task " + taskId + "is ended by " + Thread.currentThread().getName());
              });
      //      executorService.execute(
      //          new Runnable() {
      //            @Override
      //            public void run() {
      //              System.out.println(
      //                  "Task " + taskId + "is running at " + Thread.currentThread().getName());
      //              try {
      //                Thread.sleep(3000);
      //              } catch (InterruptedException ignored) {}
      //              System.out.println(
      //                  "Task " + taskId + "is ended by " + Thread.currentThread().getName());
      //            }
      //          });
    }
    executorService.shutdown(); // các thread chưa xong vẫn chạy xong trước khi shutdown pool
    //executorService.shutdownNow(); // dừng lập tức
  }
}
