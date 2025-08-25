package core.finalstatic;

class Student {
    String name;
    // Thuộc tính static - đếm số sinh viên
    static int count = 0;

    // Constructor
    public Student(String name) {
        this.name = name;
        count++;
    }

    // Phương thức static - hiển thị tổng số sinh viên
    static void showTotalStudents() {
        System.out.println("Tổng số sinh viên: " + count);
    }
}

public class DemoStatic {
    public static void main(String[] args) {
        // Tạo object
        Student s1 = new Student("An");
        Student s2 = new Student("Bình");

        // Gọi biến static qua class
        System.out.println("Số sinh viên hiện tại: " + Student.count);

        // Gọi phương thức static qua class
        Student.showTotalStudents();

        // Có thể gọi qua object, nhưng không khuyến khích
        s1.showTotalStudents(); // vẫn chạy, nhưng dễ gây nhầm rằng method đó gắn với object s1, trong khi thực ra nó là của cả class.
    }
}
