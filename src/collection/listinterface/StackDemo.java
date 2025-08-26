package collection.listinterface;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack sau push: " + stack); // [10, 20, 30]

        // 2. Lấy phần tử đỉnh nhưng không xóa (peek)
        System.out.println("Phần tử đỉnh (peek): " + stack.peek()); // 30

        // 3. Lấy và xóa phần tử đỉnh (pop)
        System.out.println("Pop(): " + stack.pop()); // 30
        System.out.println("Stack sau pop: " + stack); // [10, 20]

        // 4. Kiểm tra stack rỗng
        System.out.println("Stack rỗng? " + stack.empty()); // false

        // 5. Tìm vị trí phần tử (tính từ đỉnh stack, 1-based)
        System.out.println("Vị trí của 10: " + stack.search(10)); // 2

        // 6. Duyệt Stack
        System.out.print("Duyệt Stack: ");
        for (Integer num : stack) {
            System.out.print(num + " ");
        }
    }
}
