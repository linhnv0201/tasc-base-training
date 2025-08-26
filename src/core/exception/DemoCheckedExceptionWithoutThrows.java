package core.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// ko cần throws là do Luật của Checked Exception: Nếu trong method có thể ném ra checked exception, thì bạn buộc phải:
// Bắt (catch) exception đó trong try-catch hoặc Khai báo (throws) nó ở method signature.
// Trong main bạn đã dùng try-catch để xử lý ngay tại chỗ, nên không cần throws.
public class DemoCheckedExceptionWithoutThrows {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("abc.txt")); // có thể ném FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}