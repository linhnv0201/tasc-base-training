package thread;

class Counter {
    private int count = 0;

//    public void increment(String threadName) {
//        synchronized (this) { // lock trên object hiện tại
//            count++;
//            System.out.println(threadName + " tăng count lên: " + count);
//        }
//    }
    public synchronized void increment(String threadName) {
            count++;
            System.out.println(threadName + " tăng count lên: " + count);
    }

    public int getCount(){
        return count;
    }
}

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment(Thread.currentThread().getName());
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment(Thread.currentThread().getName());
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count cuối cùng: " + counter.getCount());
    }
}

