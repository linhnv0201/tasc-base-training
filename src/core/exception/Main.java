package core.exception;

public class Main {
    public static void main(String[] args) {
        DemoException demo = new DemoException();
        try {
            demo.checkNumber(10);   // hợp lệ
            demo.checkNumber(-5);   // ném exception
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}