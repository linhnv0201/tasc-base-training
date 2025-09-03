package excercise.demo2.repo;

import excercise.LogEntry;
import java.util.List;

public interface LogRepository {
    List<LogEntry> findAll();
}
