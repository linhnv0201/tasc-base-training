package excercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadFileService2 {
  private static final String filePath =
      "C:\\IntelliJProject\\TASC\\src\\excercise\\sample_log.txt";
  static int numThreads = Runtime.getRuntime().availableProcessors() / 2;
  static ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

  public static List<LogEntry> loadLogs() {
    List<LogEntry> allLogs = new ArrayList<>();

    try {
      int totalLines = 0;
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        while (br.readLine() != null) totalLines++;
      }

      int chunkSize = totalLines / numThreads;
      List<List<LogEntry>> partialResults = new ArrayList<>();

      // Tạo danh sách "task" cho từng thread
      for (int i = 0; i < numThreads; i++) {
        int startLine = i * chunkSize;
        int endLine = (i == numThreads - 1) ? totalLines : startLine + chunkSize;

        List<LogEntry> localList = new ArrayList<>();
        partialResults.add(localList);

        int finalStartLine = startLine;
        int finalEndLine = endLine;

        executorService.submit(
            () -> {
              try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                int currentLine = 0;
                String line;
                while ((line = br.readLine()) != null) {
                  if (currentLine >= finalStartLine && currentLine < finalEndLine) {
                    parseAndAddLog(line, localList);
                  }
                  currentLine++;
                  if (currentLine >= finalEndLine) break;
                }
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
      }

      executorService.shutdown();
      while (!executorService.isTerminated()) {
        Thread.sleep(100);
      }

      // Merge tất cả list lại
      for (List<LogEntry> part : partialResults) {
        allLogs.addAll(part);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return allLogs;
  }

  private static void parseAndAddLog(String log, List<LogEntry> logs) {
    String[] parts = log.split("]");
    String timestamp = parts[0].substring(1);
    String level = parts[1].trim().substring(1);
    String service = parts[2].trim().substring(1);
    String message = parts[3].substring(2).trim();
    logs.add(new LogEntry(timestamp, level, service, message));
  }

  public static String getFilePath() {
    return filePath;
  }
}
