package spring.demo.tightcoupling;

public class Client {
    private EmailService emailService = new EmailService();
    public void processMessage(String message){
        emailService.sendMessage(message);

    }
}
