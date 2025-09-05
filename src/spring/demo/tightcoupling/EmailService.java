package spring.demo.tightcoupling;

public class EmailService {
    public void sendMessage(String message){
    System.out.println("Send email: " + message);
    }
}
