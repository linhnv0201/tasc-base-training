package core.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompareTry {

    // Cách 1: try-catch-finally (cũ)
    static void readFileOldWay(String fileName) {
        Scanner sc = null; // (1) khai báo ngoài
        try {
            sc = new Scanner(new File(fileName)); // (2) khởi tạo trong try
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error (old way): " + e.getMessage());
        } finally {
            if (sc != null) { // (3) phải tự check null
                sc.close();   // (4) phải tự đóng
            }
        }
    }

    // Cách 2: try-with-resources (mới, gọn hơn)
    static void readFileNewWay(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))) { // (1)+(2) gộp vào try
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error (new way): " + e.getMessage());
        }
        // (3)(4) không cần, JVM tự động close() khi kết thúc
    }

    public static void main(String[] args) {
        System.out.println("=== Old Way ===");
        readFileOldWay("abc.txt");

        System.out.println("\n=== New Way ===");
        readFileNewWay("abc.txt");
    }
}
