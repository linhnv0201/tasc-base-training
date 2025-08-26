package core.oop;

class Parent1 {
    private void show1() {
        System.out.println("Parent show");
    }
}

class Child1 extends Parent1 {
    void show() { // đây là method mới, không override
        System.out.println("Child show");
    }
}

public class TestOverridePrivate {
    public static void main(String[] args) {
        Child1 c = new Child1();
        c.show(); // Child show
    }
}