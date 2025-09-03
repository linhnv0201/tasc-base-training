package excercise.demo2.controller;

import excercise.LogEntry;
import excercise.demo2.service.LogService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class LogController {
  private final LogService logService;
  private final Scanner scanner = new Scanner(System.in);

  public LogController(LogService logService) {
    this.logService = logService;
  }

  public void start() {
    boolean running = true;
    while (running) {
      System.out.println("\n===== MENU TÌM KIẾM LOG =====");
      System.out.println("1. Tìm theo level (INFO/WARN/ERROR)");
      System.out.println("2. Tìm theo khoảng thời gian");
      System.out.println("3. Tìm theo từ khóa trong message");
      System.out.println("4. Thoát");
      System.out.print("Chọn: ");
      int choice = Integer.parseInt(scanner.nextLine());

      List<LogEntry> result = null;

      switch (choice) {
        case 1:
          result = searchByLevel();
          break;
        case 2:
          result = searchByTimeRange();
          break;
        case 3:
          result = searchByMessage();
          break;
        case 4:
          running = false;
          System.out.println("Thoát chương trình.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ.");
      }

      if (result != null && !result.isEmpty()) {
        askExport(result);
      } else if (choice != 4) {
        System.out.println("Không có log nào thỏa mãn tiêu chí tìm kiếm.");
      }
    }
  }

  private List<LogEntry> searchByLevel() {
    System.out.print("Nhập level cần tìm (INFO/WARN/ERROR): ");
    String level = scanner.nextLine();
    long start = System.currentTimeMillis();
    List<LogEntry> result = logService.searchByLevel(level);
    result.forEach(System.out::println);
    long end = System.currentTimeMillis();
    System.out.println("Thời gian chạy: " + (end - start) + " ms");
    return result;
  }

  private List<LogEntry> searchByTimeRange() {
    System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
    String startInput = scanner.nextLine();
    System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
    String endInput = scanner.nextLine();
    long start = System.currentTimeMillis();
    List<LogEntry> result = logService.searchByTimeRange(startInput, endInput);
    result.forEach(System.out::println);
    long end = System.currentTimeMillis();
    System.out.println("Thời gian chạy: " + (end - start) + " ms");
    return result;
  }

  private List<LogEntry> searchByMessage() {
    System.out.print("Nhập từ khóa cần tìm trong message: ");
    String keyword = scanner.nextLine();
    long start = System.currentTimeMillis();
    List<LogEntry> result = logService.searchByMessage(keyword);
    result.forEach(System.out::println);
    long end = System.currentTimeMillis();
    System.out.println("Thời gian chạy: " + (end - start) + " ms");
    return result;
  }

  private void askExport(List<LogEntry> result) {
    System.out.print("\nBạn có muốn xuất kết quả ra file txt không? (Y/N): ");
    String export = scanner.nextLine();
    if (export.equalsIgnoreCase("Y")) {
      System.out.print("Nhập tên file xuất (ví dụ: result.txt): ");
      String fileName = scanner.nextLine();
      String parentDir =
          new File("C:\\IntelliJProject\\TASC\\src\\excercise\\demo2").getAbsolutePath();
      String newFilePath = parentDir + File.separator + fileName;
      logService.exportToFile(result, newFilePath);
    }
  }
}
