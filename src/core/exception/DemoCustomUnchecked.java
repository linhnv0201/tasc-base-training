package core.exception;

// Bước 1: tạo exception
class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

// Bước 2: dùng exception
public class DemoCustomUnchecked {
    static void divide(int a, int b) {
        if (b == 0) {
            throw new MyUncheckedException("Cannot divide by zero");
        }
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        divide(10, 0); // ném unchecked exception, không cần try-catch
        System.out.println("Program continues...");
    }
}

