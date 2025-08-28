package thread;

public class CreateThreadDemo {

    // Cách 1: Kế thừa Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread kế thừa Thread đang chạy...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread kế thừa Thread kết thúc");
        }
    }

    // Cách 2: Implement Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread implement Runnable đang chạy...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread implement Runnable kết thúc");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo thread kế thừa Thread
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("t1.isAlive(): " + t1.isAlive());
        System.out.println("t1.getState(): " + t1.getState());

        // Khởi tạo thread implement Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.println("t2.isAlive(): " + t2.isAlive());
        System.out.println("t2.getState(): " + t2.getState());

        // Chờ tất cả thread kết thúc
        t1.join();
        t2.join();

        System.out.println("Sau khi join:");
        System.out.println("t1.isAlive(): " + t1.isAlive() + ", state: " + t1.getState());
        System.out.println("t2.isAlive(): " + t2.isAlive() + ", state: " + t2.getState());
    }
}
