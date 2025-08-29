package excercise;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchSolution {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static void main(String[] args) {
    long start1 = System.currentTimeMillis();
    List<LogEntry> logs = ReadFileService.loadLogs();
    long end1 = System.currentTimeMillis();
    System.out.println("Chạy " + (end1 - start1));
    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    while (running) {
      System.out.println("\n===== MENU TÌM KIẾM LOG =====");
      System.out.println("1. Tìm theo level (INFO/WARN/ERROR)");
      System.out.println("2. Tìm theo khoảng thời gian");
      System.out.println("3. Tìm theo từ khóa trong message");
      System.out.println("4. Thoát");
      System.out.print("Chọn: ");
      int choice = Integer.parseInt(scanner.nextLine());

      List<LogEntry> result = new ArrayList<>();

      switch (choice) {
        case 1:
          System.out.print("Nhập level cần tìm (INFO/WARN/ERROR): ");
          String level = scanner.nextLine();
          long start2 = System.currentTimeMillis();
          for (LogEntry log : logs) {
            if (log.level.equalsIgnoreCase(level)) {
              System.out.println(log);
              result.add(log);
            }
          }
          long end2 = System.currentTimeMillis();
          System.out.println("Chạy " + (end2 - start2) + "ms");
          break;

        case 2:
          System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
          LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), formatter);
          System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
          LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), formatter);
          long start3 = System.currentTimeMillis();
          for (LogEntry log : logs) {
            LocalDateTime ts = log.timestamp;
            if (!ts.isBefore(start) && !ts.isAfter(end)) {
              System.out.println(log);
              result.add(log);
            }
          }
          long end3 = System.currentTimeMillis();
          System.out.println("Chạy " + (end3 - start3) + "ms");
          break;

        case 3:
          System.out.print("Nhập từ khóa cần tìm trong message: ");
          String keyword = scanner.nextLine();
          long start4 = System.currentTimeMillis();
          for (LogEntry log : logs) {
            if (log.message.toLowerCase().contains(keyword.toLowerCase())) {
              System.out.println(log);
              result.add(log);
            }
          }
          long end4 = System.currentTimeMillis();
          System.out.println("Chạy " + (end4 - start4) + "ms");
          break;

        case 4:
          running = false;
          System.out.println("Thoát chương trình.");
          break;

        default:
          System.out.println("Lựa chọn không hợp lệ.");
      }

      // Hỏi xuất file ngay sau khi tìm kiếm
      if (!result.isEmpty()) {
        System.out.print("\nBạn có muốn xuất kết quả ra file txt không? (Y/N): ");
        String export = scanner.nextLine();
        if (export.equalsIgnoreCase("Y")) {
          System.out.print("Nhập tên file xuất (ví dụ: result.txt): ");
          String fileName = scanner.nextLine();

          // Lấy thư mục chứa sample_log.txt
          File inputFile = new File(ReadFileService.getFilePath());
          String parentDir = inputFile.getParent(); // C:\IntelliJProject\TASC\src\excercise
          String newFilePath = parentDir + File.separator + fileName;

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            for (LogEntry log : result) {
              writer.write(log.toString());
              writer.newLine();
            }
            System.out.println("Đã xuất thành công " + newFilePath);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          System.out.println("Kết quả không được xuất file.");
        }
        result.clear(); // xóa dữ liệu tạm
      } else {
        System.out.println("Không có log nào thỏa mãn tiêu chí tìm kiếm.");
      }

      if (choice != 4) {
        System.out.print("\nBạn có muốn tìm tiếp không? (Y/N): ");
        String again = scanner.nextLine();
        if (again.equalsIgnoreCase("N")) {
          running = false;
          System.out.println("Thoát chương trình.");
        }
      }
    }
  }
}
