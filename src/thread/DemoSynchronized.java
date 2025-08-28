//package thread;
//
//class Counter {
//  private int count = 0;
//
//    public void increment() { //lock cả method
//      count++;
//    }
////  public void increment() {
////    // Chỉ lock đoạn code nhỏ cần thiết
////    synchronized (this) {
////      count++;
////    }
////  }
//
//  public int getCount() {
//    return count;
//  }
//}
//
//public class DemoSynchronized {
//  public static void main(String[] args) throws InterruptedException {
//    Counter c = new Counter();
//
//    Thread t1 =
//        new Thread(
//            () -> {
//              for (int i = 0; i < 10000; i++) c.increment();
//            });
//    Thread t2 =
//        new Thread(
//            () -> {
//              for (int i = 0; i < 10000; i++) c.increment();
//            });
//
//    t1.start();
//    t2.start();
//    t1.join();
//    t2.join();
//
//    System.out.println("Kết quả: " + c.getCount());
//  }
//}
