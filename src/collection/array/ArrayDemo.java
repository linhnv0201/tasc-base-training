package collection.array;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // 1. Khai báo và khởi tạo mảng
        int[] numbers = new int[5]; // mảng 5 phần tử mặc định = 0
        int[] primes = {2, 3, 5, 7, 11};

        // 2. Gán giá trị
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        // 3. Truy cập phần tử
        System.out.println("Phần tử đầu tiên: " + numbers[0]);
        System.out.println("Phần tử cuối cùng: " + numbers[numbers.length - 1]);

        // 4. Duyệt mảng
        System.out.println("\nDuyệt bằng for thường:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\n\nDuyệt bằng for-each:");
        for (int n : primes) {
            System.out.print(n + " ");
        }

        // 5. Tìm kiếm phần tử
        int x = 30;
        boolean found = false;
        for (int n : numbers) {
            if (n == x) {
                found = true;
                break;
            }
        }
    //        System.out.println("\n\nTìm số " + x + ": " + (found ? "Có trong mảng" : "Không có"));
        System.out.println("\n\nTìm số " + x + (found ? " Có": " Không"));
        // 6. Sắp xếp mảng
        int[] unsorted = {9, 1, 6, 3, 7};
        System.out.println("\nTrước khi sắp xếp: " + Arrays.toString(unsorted));
        Arrays.sort(unsorted);
        System.out.println("Sau khi sắp xếp: " + Arrays.toString(unsorted));

        // 7. Copy mảng
        int[] copy = Arrays.copyOf(primes, primes.length);
        System.out.println("\nMảng copy: " + Arrays.toString(copy));

        // 8. Mảng nhiều chiều (2D array)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("\nDuyệt mảng 2 chiều:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
