package spring.demo.loosecoupling;

public class EmailService implements MessageService{
    public void sendMessage(String message){
    System.out.println("Send email:" + message);
    }
}
