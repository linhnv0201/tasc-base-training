package spring.demo.loosecoupling;

public class SMSService implements MessageService{
    public void sendMessage(String message){
        System.out.println("Send sms:" + message);
    }
}
