package excercise.demo2.util;

import excercise.LogEntry;

public class LogParser {
    public static LogEntry parse(String log) {
        try {
            String[] parts = log.split("]");
            String timestamp = parts[0].substring(1).trim();
            String level = parts[1].trim().substring(1).trim();
            String service = parts[2].trim().substring(1).trim();
            String message = parts[3].substring(2).trim();
            return new LogEntry(timestamp, level, service, message);
        } catch (Exception e) {
            System.err.println("Invalid log line: " + log);
            return null;
        }
    }
}
