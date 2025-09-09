package core.demo.abstractclass;

public class AdminUser extends User {
   public AdminUser(String id, String name, String email){
       super(id, name, email);
   }

   @Override
    public void login(){
        System.out.println("Admin: " + name + "đã login" );
   }
}
