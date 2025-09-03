package excercise.demo2;

import excercise.demo2.controller.LogController;
import excercise.demo2.repo.FileLogRepository;
import excercise.demo2.repo.LogRepository;
import excercise.demo2.service.LogService;
import excercise.demo2.service.LogServiceImpl;

public class Application {
    public static void main(String[] args) {
        String path = "C:\\IntelliJProject\\TASC\\src\\excercise\\sample_log.txt";
        LogRepository repo = new FileLogRepository(path);
        LogService service = new LogServiceImpl(repo);
        LogController controller = new LogController(service);
        controller.start();
    }
}
