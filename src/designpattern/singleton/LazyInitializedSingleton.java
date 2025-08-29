package designpattern.singleton;

// mở rộng hơn so với 2 cách làm trên và hoạt động tốt trong môi trường đơn luồng (single-thread).
public class LazyInitializedSingleton {
  private static LazyInitializedSingleton instance;

  private LazyInitializedSingleton() {}

  public static LazyInitializedSingleton getInstance() {
    if (instance == null) {
      instance = new LazyInitializedSingleton();
    }
    return instance;
  }
}
