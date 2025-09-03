package excercise.demo2.service;

import excercise.LogEntry;
import excercise.demo2.repo.LogRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogServiceImpl implements LogService {
  private final List<LogEntry> allLogs;

  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public LogServiceImpl(LogRepository repository) {
    this.allLogs = repository.findAll();
  }

  // single-thread

  //  @Override
  //  public List<LogEntry> searchByLevel(String level) {
  //    List<LogEntry> result = new ArrayList<>();
  //    for (LogEntry log : allLogs) {
  //      if (log.getLevel().equalsIgnoreCase(level)) result.add(log);
  //    }
  //    return result;
  //  }
  //
//    @Override
//    public List<LogEntry> searchByTimeRange(String from, String to) {
//      List<LogEntry> result = new ArrayList<>();
//      LocalDateTime start = LocalDateTime.parse(from, formatter);
//      LocalDateTime end = LocalDateTime.parse(to, formatter);
//
//      for (LogEntry log : allLogs) {
//        LocalDateTime ts = log.getTimestamp();
//        if (!ts.isBefore(start) && !ts.isAfter(end)) result.add(log);
//      }
//      return result;
//    }
  //
  //  @Override
  //  public List<LogEntry> searchByMessage(String keyword) {
  //    List<LogEntry> result = new ArrayList<>();
  //    String lower = keyword.toLowerCase();
  //    for (LogEntry log : allLogs) {
  //      if (log.getMessage().toLowerCase().contains(lower)) result.add(log);
  //    }
  //    return result;
  //  }

  @Override
  public List<LogEntry> searchByLevel(String level) {
    int mid = allLogs.size() / 2;
    List<LogEntry> result = Collections.synchronizedList(new ArrayList<>());

    Thread t1 =
        new Thread(
            () -> {
              for (int i = 0; i < mid; i++) {
                LogEntry log = allLogs.get(i);
                if (log.getLevel().equalsIgnoreCase(level)) {
                  result.add(log);
                }
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              for (int i = mid; i < allLogs.size(); i++) {
                LogEntry log = allLogs.get(i);
                if (log.getLevel().equalsIgnoreCase(level)) {
                  result.add(log);
                }
              }
            });

    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return result;
  }

  // 2 luồng nhưng add vào 1 synchronized list
  //  @Override
  //  public List<LogEntry> searchByTimeRange(String from, String to) {
  //    List<LogEntry> result = Collections.synchronizedList(new ArrayList<>());
  //
  //    // Parse String -> LocalDateTime giống bản single-thread
  //    LocalDateTime startTime = LocalDateTime.parse(from, formatter);
  //    LocalDateTime endTime = LocalDateTime.parse(to, formatter);
  //
  //    int mid = allLogs.size() / 2;
  //
  //    Thread t1 = new Thread(() -> {
  //      for (int i = 0; i < mid; i++) {
  //        LogEntry log = allLogs.get(i);
  //        LocalDateTime ts = log.getTimestamp();
  //        if (!ts.isBefore(startTime) && !ts.isAfter(endTime)) {
  //          result.add(log);
  //        }
  //      }
  //    });
  //
  //    Thread t2 = new Thread(() -> {
  //      for (int i = mid; i < allLogs.size(); i++) {
  //        LogEntry log = allLogs.get(i);
  //        LocalDateTime ts = log.getTimestamp();
  //        if (!ts.isBefore(startTime) && !ts.isAfter(endTime)) {
  //          result.add(log);
  //        }
  //      }
  //    });
  //
  //    long start = System.currentTimeMillis();
  //
  //    t1.start();
  //    t2.start();
  //
  //    try {
  //      t1.join();
  //      t2.join();
  //    } catch (InterruptedException e) {
  //      e.printStackTrace();
  //    }
  //
  //    long end = System.currentTimeMillis();
  //    System.out.println(
  //            "⏱️ Tìm xong " + result.size() + " dòng (theo time range) bằng 2 thread trong "
  //                    + (end - start) + "ms"
  //    );
  //
  //    return result;
  //  }

  //  // 2 luồng 2 add vào 2 list xong mới gộp lại
  @Override
  public List<LogEntry> searchByTimeRange(String from, String to) {
    LocalDateTime start = LocalDateTime.parse(from, formatter);
    LocalDateTime end = LocalDateTime.parse(to, formatter);

    List<LogEntry> result1 = new ArrayList<>();
    List<LogEntry> result2 = new ArrayList<>();
    int mid = allLogs.size() / 2;

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < mid; i++) {
        LogEntry log = allLogs.get(i);
        LocalDateTime ts = log.getTimestamp();
        if (!ts.isBefore(start) && !ts.isAfter(end)) {
          result1.add(log);
        }
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = mid; i < allLogs.size(); i++) {
        LogEntry log = allLogs.get(i);
        LocalDateTime ts = log.getTimestamp();
        if (!ts.isBefore(start) && !ts.isAfter(end)) {
          result2.add(log);
        }
      }
    });

    long t0 = System.currentTimeMillis();

    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // merge
    result1.addAll(result2);

    long t1End = System.currentTimeMillis();
    System.out.println("⏱️ Tìm xong " + result1.size() +
            " dòng (theo time range) bằng 2 thread trong " + (t1End - t0) + "ms");

    return result1;
  }


  @Override
  public List<LogEntry> searchByMessage(String keyword) {
    List<LogEntry> result = Collections.synchronizedList(new ArrayList<>());
    String lowerKeyword = keyword.toLowerCase();
    int mid = allLogs.size() / 2;

    Thread t1 =
        new Thread(
            () -> {
              for (int i = 0; i < mid; i++) {
                LogEntry log = allLogs.get(i);
                if (log.getMessage().toLowerCase().contains(lowerKeyword)) {
                  result.add(log);
                }
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              for (int i = mid; i < allLogs.size(); i++) {
                LogEntry log = allLogs.get(i);
                if (log.getMessage().toLowerCase().contains(lowerKeyword)) {
                  result.add(log);
                }
              }
            });

    long start = System.currentTimeMillis();

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();
    System.out.println(
        "⏱️ Tìm xong "
            + result.size()
            + " dòng (theo message) bằng 2 thread trong "
            + (end - start)
            + "ms");

    return result;
  }

  @Override
  public void exportToFile(List<LogEntry> logs, String outputPath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
      for (LogEntry log : logs) {
        writer.write(log.toString());
        writer.newLine();
      }
      System.out.println("✅ Đã xuất thành công: " + outputPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
