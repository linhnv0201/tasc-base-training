package core.cast;

class Father {
    void show() {
        System.out.println("Father show");
    }

    void parentsMethod() {
        System.out.println("Only Father can do");
    }
}

class Son extends Father {
    @Override
    void show() {
        System.out.println("Son show");
    }

    void sonsMethod() {
        System.out.println("Only Son can do");
    }
}

public class TestCasting {
    public static void main(String[] args) {
        // 1. Inheritance (không ép kiểu)
        System.out.println("=== Inheritance (no casting) ===");
        Son c = new Son();
        c.show();            // Son show
        c.parentsMethod();   // Only Father can do
        c.sonsMethod();      // Only Son can do

        // 2. Upcasting (Son -> Father)
        System.out.println("\n=== Upcasting (Son -> Father) ===");
        Father f1 = new Son();  // upcast tự động
        f1.show();              // Son show (runtime binding)
        f1.parentsMethod();     // Only Father can do
        // f1.sonsMethod();     // ❌ không gọi được, vì kiểu Father không có

        // 3. Downcasting (Father -> Son)
        System.out.println("\n=== Downcasting (Father -> Son) ===");
        ((Son) f1).sonsMethod(); // ép kiểu để gọi method riêng của Son

        // 4. Sai Downcasting -> ClassCastException
        System.out.println("\n=== Wrong Downcasting ===");
        Father f2 = new Father();
        // ((Son) f2).sonsMethod(); // ❌ Runtime Error: ClassCastException
    }
}
