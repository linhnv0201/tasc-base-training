package excercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    LocalDateTime timestamp;
    String level;
    String service;
    String message;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogEntry(String timestamp, String level, String service, String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.parse(timestamp, formatter);
        this.level = level;
        this.service = service;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + timestamp.format(formatter) + "] "
                + "[" + level + "] "
                + "[" + service + "] - "
                + message;
    }
}
