package core.finalstatic;

class DemoFinal {
    public static void main(String[] args) {
        // Biến final với kiểu nguyên thủy
        final int x = 10;
        // x = 20; // ❌ Lỗi biên dịch - không thể gán lại

        // Biến final với object
        final StringBuilder sb = new StringBuilder("Hello");
        // sb = new StringBuilder("World"); // ❌ Không thể gán lại object khác
        sb.append(" World"); // ✅ Nhưng có thể thay đổi nội dung bên trong
        System.out.println(sb); // In ra: Hello World

        // Biến final với mảng
        final int[] arr = {1, 2, 3};
        arr[0] = 10; //  Thay đổi phần tử được
        // arr = new int[]{4, 5}; // ❌ Không thể gán mảng mới
        System.out.println(arr[0]); // In ra: 10
    }
}

