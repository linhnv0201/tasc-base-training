//package core.oop;
//
//// Abstract class
//abstract class Vehiclex {
//    protected String brand;
//
//    public Vehiclex(String brand) {
//        this.brand = brand;
//    }
//
//    // Abstract method trả về String
//    public abstract String startEngine();
//}
//
//// Class implement cả abstract class và interface
//class Car extends Vehiclex implements GPS {
//
//    public Car(String brand) {
//        super(brand);
//    }
//
//    // ❌ Lỗi: không thể override cùng lúc do return type khác
//    /*
//    @Override
//    public void startEngine() {
//        System.out.println(brand + " engine started");
//    }
//    */
//
//    // Giải pháp: phải rename method hoặc chỉ implement một method phù hợp
//    @Override
//    public String startEngine() { // override abstract class
//        return brand + " engine started";
//    }
//
//    @Override
//    public void showLocation() { // interface riêng
//        System.out.println(brand + " current location: 10.123N, 20.456E");
//    }
//}
//
//// Demo
//public class DemoOverrideWithAbstractInterfaceConflict {
//    public static void main(String[] args) {
//        Car myCar = new Car("Toyota");
//
//        System.out.println(myCar.startEngine()); // gọi abstract class method
//        myCar.showLocation(); // gọi interface method
//    }
//}
