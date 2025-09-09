package excercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    private LocalDateTime timestamp;
    private String level;
    private String service;
    private String message;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getService() {
        return service;
    }

    public String getMessage() {
        return message;
    }

    public LogEntry(String timestamp, String level, String service, String message) {
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
