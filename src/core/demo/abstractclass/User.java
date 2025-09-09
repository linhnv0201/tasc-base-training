package core.demo.abstractclass;

import java.time.LocalDateTime;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;

    protected static int countUser = 0;
    public static final String DEFAULT_ROLE = "GUEST";

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        countUser++;
    }

    // abstract method so that subclass must to implement
    public abstract void login();

    //concrete method, dùng chung đc
    public void logout(){
        System.out.println(name + " đã logout lúc " + LocalDateTime.now());
    }

    // 7. Final method (subclass không thể override)
    public final String getEmail() {
        return this.email;
    }

    // 8. Static method (gọi mà không cần object)
    public static int getUserCount() {
        return countUser;
    }

    // 9. Nested enum
    public enum Role {
        ADMIN, CUSTOMER, GUEST
    }

    // 10. Nested static class
    public static class Audit {
        public static void log(String message) {
            System.out.println("[AUDIT] " + message);
        }
    }

    // 11. toString() concrete
    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }
}
