package designpattern.singleton;

// Singleton Class được khởi tạo ngay khi được gọi đến.
// Đây là cách dễ nhất nhưng nó có một nhược điểm mặc dù instance đã được khởi tạo mà có thể sẽ
// không dùng tới.
// Eager initialization là cách tiếp cận tốt, dễ cài đặt, tuy nhiên, nó dễ dàng bị phá vỡ bởi
// Reflection.
public class EagerInitializedSingleton {
  private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

  private EagerInitializedSingleton() {}

  public static EagerInitializedSingleton getInstance() {
    return instance;
  }
}
