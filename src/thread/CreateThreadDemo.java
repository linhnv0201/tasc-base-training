package thread;

// Demo so sánh Thread extends Thread vs Runnable
public class CreateThreadDemo {

    // 1️⃣ Kế thừa Thread
    static class MyThread extends Thread {
        private String name;
        public MyThread(String name) { this.name = name; }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " chạy (extends Thread) - step " + i);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        }
    }

    // 2️⃣ Runnable
    static class MyRunnable implements Runnable {
        private String name;
        public MyRunnable(String name) { this.name = name; }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " chạy (Runnable) - step " + i);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread extends Thread ===");
        Thread t1 = new MyThread("T1");
        Thread t2 = new MyThread("T2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\n=== Thread + Runnable (tái sử dụng Runnable) ===");
        MyRunnable sharedRunnable = new MyRunnable("SharedRunnable");
        Thread r1 = new Thread(sharedRunnable);
        Thread r2 = new Thread(sharedRunnable);
        r1.start();
        r2.start();
        r1.join();
        r2.join();

    // Giải thích
    //
    // Thread extends Thread
    //
    // Tạo 2 thread riêng (t1, t2), logic gắn trực tiếp trong lớp.
    //
    // Mỗi thread có logic riêng, khó dùng lại.
    //
    // Thread + Runnable
    //
    // Tạo 1 Runnable object, dùng cho 2 thread khác nhau (r1, r2) → tái sử dụng logic.
    //
    // Output sẽ xen kẽ, vì cả 2 thread cùng chạy logic của Runnable.

    System.out.println("\nDemo kết thúc");
    }
}
