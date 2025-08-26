package core.memory;

class DemoHeapStack {
    String name; // instance variable -> heap

    DemoHeapStack(String name) {
        this.name = name;
    }

    void show() {
        int x = 10;                 // primitive -> stack
        String localStr = "Hello";  // literal -> pool
        DemoHeapStack obj = new DemoHeapStack("Obj"); // object -> heap, reference -> stack

        System.out.println("x (primitive): " + x);
        System.out.println("localStr (reference): " + localStr);
        System.out.println("obj.name (object in heap): " + obj.name);
        System.out.println("this.name (instance variable in heap): " + this.name);
    }

    public static void main(String[] args) {
        DemoHeapStack demo1 = new DemoHeapStack("Demo1"); // object -> heap, reference -> stack in main
        DemoHeapStack demo2 = new DemoHeapStack("Demo2");

        demo1.show();
        demo2.show();

        System.out.println("demo1.name: " + demo1.name);
        System.out.println("demo2.name: " + demo2.name);
    }
}

