package test;

public class OverloadTest {
    protected void hello(){}
    private void hello(int id){
    System.out.println(" ");
    }

  public static void main(String[] args) {
    OverloadTest overloadTest = new OverloadTest();
    overloadTest.hello();
    overloadTest.hello();
  }
}
