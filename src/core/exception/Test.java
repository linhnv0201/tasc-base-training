package core.exception;

public class Test {
  public static void main(String[] args) {
    //
    int[] a = {1, 2, 3, 4, 5};
    try {
      for (int x = 0; x <= a.length; x++) {
        System.out.println(a[x]);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("tràn:" + e.getMessage());
    }
  }
}
