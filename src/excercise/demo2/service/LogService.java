package excercise.demo2.service;

import excercise.LogEntry;

import java.util.List;

public interface LogService {
    List<LogEntry> searchByLevel(String level);
    List<LogEntry> searchByTimeRange(String from, String to);
    List<LogEntry> searchByMessage(String keyword);
    void exportToFile(List<LogEntry> logs, String outputPath);
}
