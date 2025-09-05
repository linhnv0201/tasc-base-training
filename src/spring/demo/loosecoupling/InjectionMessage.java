package spring.demo.loosecoupling;

// interface này chỉ dùng để demo interface injection
public interface InjectionMessage {
    public void setService(MessageService messageServiceParam);
}
