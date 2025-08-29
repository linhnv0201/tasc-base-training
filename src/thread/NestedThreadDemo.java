package thread;

public class NestedThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 bắt đầu");

            Thread t2 = new Thread(() -> {
                System.out.println("Thread-2 bắt đầu");
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                System.out.println("Thread-2 kết thúc");
            });

            t2.start(); // khởi tạo và start t2 bên trong t1

            try { t2.join(); } catch (InterruptedException e) {}
            System.out.println("Thread-1 kết thúc");
        });

        t1.start();
    }
}

