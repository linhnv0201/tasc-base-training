package excercise.demo2.repo;


import excercise.LogEntry;
import excercise.demo2.util.LogParser;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class FileLogRepository implements LogRepository {
    private final String filePath;
    private final int numThreads;

    public FileLogRepository(String filePath) {
        this.filePath = filePath;
        this.numThreads = Math.max(1, Runtime.getRuntime().availableProcessors() / 2);
    }

    @Override
    public List<LogEntry> findAll() {
        List<LogEntry> result = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        try {
            int totalLines = countLines();
            int chunkSize = totalLines / numThreads;
            List<Future<?>> futures = new ArrayList<>();

            for (int i = 0; i < numThreads; i++) {
                int startLine = i * chunkSize;
                int endLine = (i == numThreads - 1) ? totalLines : startLine + chunkSize;

                futures.add(executor.submit(() -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        int currentLine = 0;
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (currentLine >= startLine && currentLine < endLine) {
                                LogEntry entry = LogParser.parse(line);
                                if (entry != null) result.add(entry);
                            }
                            currentLine++;
                            if (currentLine >= endLine) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));
            }

            for (Future<?> f : futures) f.get(); // chờ tất cả task xong

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return result;
    }

    private int countLines() throws IOException {
        int total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) total++;
        }
        return total;
    }
}
