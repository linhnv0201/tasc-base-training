package core.oop;

class Parent2 {
    public static void show() {
        System.out.println("Parent static show");
    }
}

class Child2 extends Parent2 {
    public static void show() { // không override, chỉ là hiding
        System.out.println("Child static show");
    }
}

public class TestStaticOverride {
    public static void main(String[] args) {
        Parent2.show(); // Parent static show
        Child2.show();  // Child static show

        Parent2 p = new Child2();
        p.show();      // Parent static show (không polymorphism)
    }
}
