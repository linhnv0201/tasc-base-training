package spring.demo.loosecoupling;

//chỉ implements khi dùng với interface injection
public class Client implements InjectionMessage {
    private MessageService messageService;

    //constructor injection
//    public Client(MessageService messageServiceParam){
//        this.messageService = messageServiceParam;
//    }

    //setter injection
    public void setMessageService(MessageService messageServiceParam){
        this.messageService = messageServiceParam;
    }

    @Override
    public void setService(MessageService messageService){
        this.messageService = messageService;
    }

    public void processMessage(String message){
        messageService.sendMessage(message);
    }
}
