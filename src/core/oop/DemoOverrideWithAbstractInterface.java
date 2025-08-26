package core.oop;

// Abstract class
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void startEngine(); // abstract method
}

// Interface
interface GPS {
    void startEngine(); // method cùng tên, cùng kiểu trả về
    void showLocation();
}

// Class implement cả abstract class và interface
class Car extends Vehicle implements GPS {

    public Car(String brand) {
        super(brand);
    }

    // Override abstract method từ Vehicle và interface GPS cùng 1 method
    @Override
    public void startEngine() {
        System.out.println(brand + " engine started");
    }

    // Override method riêng của interface
    @Override
    public void showLocation() {
        System.out.println(brand + " current location: 10.123N, 20.456E");
    }
}

// Demo
public class DemoOverrideWithAbstractInterface {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota");

        myCar.startEngine();  // Gọi method override từ abstract class + interface
        myCar.showLocation(); // Gọi method override riêng interface
    }
}
