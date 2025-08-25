package core.string;

public class StringBenchmark {
    public static void main(String[] args) {
        int N = 100_000; // số lần nối chuỗi

        // Test String (immutable)
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // tạo ra object mới mỗi lần
        }
        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        // Test StringBuilder (mutable)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // Test StringBuffer (mutable, synchronized)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}

