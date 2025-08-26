package core.exception;

// Định nghĩa Checked Exception riêng
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class DemoCheckedException2 {

    // Method này có thể ném Checked Exception
    static int sqrt(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Cannot calculate sqrt of negative number: " + number);
        }
        return (int) Math.sqrt(number);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Sqrt of 9 = " + sqrt(9));
            System.out.println("Sqrt of -4 = " + sqrt(-4)); // sẽ ném Checked Exception
        } catch (NegativeNumberException e) {
            System.out.println("Caught Checked Exception: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}
