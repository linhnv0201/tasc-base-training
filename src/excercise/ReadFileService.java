package excercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class ReadFileService {
  private static final String filePath =
      "C:\\IntelliJProject\\TASC\\src\\excercise\\sample_log.txt";

  // Hàm đọc log từ file
  //C1
  public static List<LogEntry> loadLogs() {
    List<LogEntry> logs = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String log;
      while ((log = br.readLine()) != null) {
        parseAndAddLog(log,logs);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return logs;
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
