package core.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoCheckedException {

  // 1. Đọc file (có thể ném FileNotFoundException)
  static void readFile(String fileName) throws FileNotFoundException   {
    Scanner sc = new Scanner(new File(fileName)); // Checked Exception
    System.out.println("File content:");
    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
    }
    sc.close();
  }

  // 2. Ghi file (có thể ném IOException)
  static void writeFile(String fileName, String content) throws IOException {
    FileWriter writer = new FileWriter(fileName); // Checked Exception
    writer.write(content);
    writer.close();
    System.out.println("Write file success!");
  }

  // 3. Parse ngày tháng (có thể ném ParseException)
  static Date parseDate(String dateStr) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.parse(dateStr); // Checked Exception
  }

  public static void main(String[] args) {
    try {
      // Thử đọc file không tồn tại
      readFile("abc.txt");
    } catch (FileNotFoundException e) {
      System.out.println("❌ Lỗi đọc file: " + e.getMessage());
    }
//    readFile("a.txt");

    try {
      // Thử ghi file
      writeFile("test.txt", "Hello Checked Exception!");
    } catch (IOException e) {
      System.out.println("❌ Lỗi ghi file: " + e.getMessage());
    }

    try {
      // Thử parse ngày sai định dạng
      Date d = parseDate("31-12-2025");
      System.out.println("Ngày hợp lệ: " + d);
    } catch (ParseException e) {
      System.out.println("❌ Lỗi định dạng ngày: " + e.getMessage());
    }

    System.out.println("✅ Program continues...");
  }
}
