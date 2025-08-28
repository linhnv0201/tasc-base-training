package excercise;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTextFile {
  private static final String filePath = "C:\\IntelliJProject\\TASC\\src\\excercise\\sample_log.txt";
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static void main(String[] args) {
    List<LogEntry> logs = loadLogs();
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
          for (LogEntry log : logs) {
            if (log.level.equalsIgnoreCase(level)) {
              System.out.println(log);
              result.add(log);
            }
          }
          break;

        case 2:
          System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
          LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), formatter);
          System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
          LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), formatter);

          for (LogEntry log : logs) {
            LocalDateTime ts = log.timestamp;
            if (!ts.isBefore(start) && !ts.isAfter(end)) {
              System.out.println(log);
              result.add(log);
            }
          }
          break;

        case 3:
          System.out.print("Nhập từ khóa cần tìm trong message: ");
          String keyword = scanner.nextLine();
          for (LogEntry log : logs) {
            if (log.message.toLowerCase().contains(keyword.toLowerCase())) {
              System.out.println(log);
              result.add(log);
            }
          }
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
          File inputFile = new File(filePath);
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

  // Hàm đọc log từ file
  private static List<LogEntry> loadLogs() {
    List<LogEntry> logs = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String log;
      while ((log = br.readLine()) != null) {
        String[] parts = log.split("]");
        String timestamp = parts[0].substring(1);
        String level = parts[1].trim().substring(1);
        String service = parts[2].trim().substring(1);
        String message = parts[3].substring(2).trim();
        logs.add(new LogEntry(timestamp, level, service, message));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return logs;
  }
}
