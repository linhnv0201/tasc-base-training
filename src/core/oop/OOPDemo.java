package core.oop;

// 🔹 Abstraction: interface mô tả hành vi chung
interface Animal {
    void makeSound(); // chỉ khai báo, không cài đặt
}

// 🔹 Inheritance: Dog kế thừa từ BaseAnimal
abstract class BaseAnimal implements Animal {
    private String name; // 🔹 Encapsulation: thuộc tính private

    public BaseAnimal(String name) {
        this.name = name;
    }

    // getter & setter -> kiểm soát truy cập
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method chung cho tất cả loài vật
    public void eat() {
        System.out.println(name + " is eating...");
    }
}

// 🔹 Dog kế thừa từ BaseAnimal (Inheritance)
class Dog extends BaseAnimal {
    public Dog(String name) {
        super(name);
    }

    // 🔹 Polymorphism (Overriding)
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

// 🔹 Cat kế thừa từ BaseAnimal (Inheritance)
class Cat extends BaseAnimal {
    public Cat(String name) {
        super(name);
    }

    // 🔹 Polymorphism (Overriding)
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Kitty");

        dog.makeSound(); // Polymorphism -> Woof Woof
        cat.makeSound(); // Polymorphism -> Meow Meow

        // Downcasting theo cách cũ (Java 11)
        if (dog instanceof BaseAnimal) {
            BaseAnimal d = (BaseAnimal) dog;
            d.eat(); // Buddy is eating...
        }
        if (cat instanceof BaseAnimal) {
            BaseAnimal c = (BaseAnimal) cat;
            c.eat(); // Kitty is eating...
        }
    }
}
