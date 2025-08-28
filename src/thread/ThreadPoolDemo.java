package thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3); // pool 3 thread

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " đang chạy bởi " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                System.out.println("Task " + taskId + " kết thúc bởi " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // sau khi hết task, pool sẽ tắt
    }
}

