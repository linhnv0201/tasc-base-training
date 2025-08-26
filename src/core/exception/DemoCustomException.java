package core.exception;

// Bước 1: tạo exception
class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

// Bước 2: dùng exception
public class DemoCustomException {
    static void checkAge(int age) throws UnderAgeException { // checked → phải throws
        if (age < 18) {
            throw new UnderAgeException("Age must be >= 18");
        } else {
            System.out.println("Age is valid: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // sẽ ném MyCheckedException
        } catch (UnderAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
