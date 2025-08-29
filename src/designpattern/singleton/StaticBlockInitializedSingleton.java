package designpattern.singleton;

// tương tự như Eager initialization chỉ khác phần static block cung cấp thêm lựa chọn cho
// việc handle exception hay các xử lý khác.
public class StaticBlockInitializedSingleton {
  private static final StaticBlockInitializedSingleton instance;

  private StaticBlockInitializedSingleton() {}

  static {
    try {
      instance = new StaticBlockInitializedSingleton();
    } catch (Exception e) {
      throw new RuntimeException("exception occured in creating singleton instance");
    }
  }

  public static StaticBlockInitializedSingleton getInstance() {
    return instance;
  }
}
