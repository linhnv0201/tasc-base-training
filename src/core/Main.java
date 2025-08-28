package core;

class Parent {
    final void show() {
        System.out.println("This is a final method");
    }
}

class Child extends Parent {
    // ❌ Không thể override
    // void show() { System.out.println("Try to override"); }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.show(); // This is a final method
    }
}
