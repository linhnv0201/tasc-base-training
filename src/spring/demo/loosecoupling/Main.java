package spring.demo.loosecoupling;

public class Main {
  public static void main(String[] args) {
//    emailService biến kiểu EmailService.
//    Bạn có thể gọi mọi phương thức của EmailService, kể cả những phương thức không nằm trong interface MessageService.
//    Biến này liên kết chặt chẽ (tight coupling) với class EmailService.
    EmailService emailService = new EmailService();

//    emailService2 biến kiểu interface MessageService, nhưng được gán một instance EmailService.
//    Bạn chỉ có thể gọi các phương thức có trong interface MessageService, không gọi được các phương thức riêng của EmailService.
//    Đây là loose coupling, vì code chỉ phụ thuộc vào abstraction (MessageService), không phải class cụ thể.
    MessageService emailService2 = new EmailService();

    SMSService smsService = new SMSService();

    // đây là gọi qua constructor injection
//    Client client = new Client(emailService);
//    client.processMessage("Hello loose coupling");
//    Client client1 = new Client(smsService);
//    client1.processMessage("Hello loose coupling hehe");

    // đây là gọi qua setter injection
//    Client client = new Client();
//    client.setMessageService(emailService);
//    client.processMessage(" Hello");

    // đây là gọi qua interface
    Client client = new Client();
    client.setMessageService(emailService);
//    client.setService(smsService);
    client.processMessage("Hello");
  }
}
