package core.datatype;

import java.util.*;
import java.util.stream.*;

public class PrimitiveVsObjectShowcase {

  // --- 0) Giá trị mặc định của field ---
  int pInt; // 0
  Integer oInt; // null
  double pDouble; // 0.0
  Double oDouble; // null
  boolean pBool; // false
  Boolean oBool; // null

  public static void main(String[] args) {
    PrimitiveVsObjectShowcase s = new PrimitiveVsObjectShowcase();
    s.defaultValues();
    s.boxingUnboxing();
    s.compareEquality();
    s.integerCachePitfall();
    s.nullAndUnboxingPitfall();
    s.collectionsAndGenerics();
    s.parsingAndFormatting();
    s.primitiveStreamsVsBoxed();
    s.performancePitfallAutoboxing();
  }

  // 1) In giá trị mặc định primitive vs object
  void defaultValues() {
    System.out.println("=== 1) Default values ===");
    System.out.println("pInt=" + pInt + ", oInt=" + oInt);
    System.out.println("pDouble=" + pDouble + ", oDouble=" + oDouble);
    System.out.println("pBool=" + pBool + ", oBool=" + oBool);
    System.out.println();
  }

  // 2) Boxing / Unboxing (tự động & thủ công)
  void boxingUnboxing() {
    System.out.println("=== 2) Boxing / Unboxing ===");
    int a = 10; // primitive
    Integer b = a; // auto-boxing
    int c = b; // auto-unboxing
    Integer d = Integer.valueOf(a); // boxing (tường minh)
    int e = d.intValue(); // unboxing (tường minh)
    System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e);
    System.out.println();
  }

  // 3) So sánh: == vs equals, NaN & +0.0/-0.0
  void compareEquality() {
    System.out.println("=== 3) Equality: primitive vs object ===");
    // Primitive: == so sánh GIÁ TRỊ
    int x = 1000, y = 1000;
    System.out.println("int: x==y ? " + (x == y)); // true

    // Wrapper: == so sánh THAM CHIẾU, equals so sánh GIÁ TRỊ
    Integer i1 = Integer.valueOf(1000);
    Integer i2 = Integer.valueOf(1000);
    System.out.println("Integer: i1==i2 ? " + (i1 == i2)); // thường false (không cache > 127)
    System.out.println("Integer: i1.equals(i2) ? " + i1.equals(i2)); // true

    // double NaN: primitive NaN != NaN, nhưng Double.equals coi NaN bằng NaN
    double d1 = Double.NaN, d2 = Double.NaN;
    System.out.println("double: NaN==NaN ? " + (d1 == d2)); // false
    Double D1 = Double.NaN, D2 = Double.NaN;
    System.out.println("Double: NaN.equals(NaN) ? " + D1.equals(D2)); // true

    // +0.0 và -0.0: primitive coi bằng nhau, Double.equals coi KHÁC (khác bit)
    double pz = 0.0, nz = -0.0;
    System.out.println("double: +0.0 == -0.0 ? " + (pz == nz)); // true
    Double PZ = 0.0, NZ = -0.0;
    System.out.println("Double: +0.0 equals -0.0 ? " + PZ.equals(NZ)); // false
    System.out.println();
  }

  // 4) Integer cache: [-128..127] có thể cùng tham chiếu
  void integerCachePitfall() {
    System.out.println("=== 4) Integer cache [-128..127] ===");
    Integer a = 127, b = 127; // cache -> có thể cùng object
    Integer c = 128, d = 128; // ngoài cache -> object khác nhau
    System.out.println("127: a==b ? " + (a == b)); // true (thường)
    System.out.println("128: c==d ? " + (c == d)); // false (thường)
    System.out.println("Luôn dùng .equals() khi so sánh wrapper!");
    System.out.println();
  }

  // 5) Null & unboxing: dễ NPE; cách so sánh an toàn
  void nullAndUnboxingPitfall() {
    System.out.println("=== 5) Null & unboxing pitfall ===");
    Integer maybeNull = null;
    try {
      int x = maybeNull; // auto-unboxing -> NullPointerException
      System.out.println(x);
    } catch (NullPointerException ex) {
      System.out.println("NPE khi unboxing Integer null -> int");
    }
    // Cách an toàn:
    int safe = (maybeNull != null) ? maybeNull : 0;
    int safe2 = Optional.ofNullable(maybeNull).orElse(0);
    System.out.println("safe=" + safe + ", safe2=" + safe2);

    // So sánh wrapper an toàn với null
    Integer A = null, B = 10;
    System.out.println("Objects.equals(A,B) an toàn với null: " + Objects.equals(A, B));
    System.out.println();
  }

  // 6) Collections & Generics: không dùng được primitive trực tiếp
  void collectionsAndGenerics() {
    System.out.println("=== 6) Collections & Generics ===");
    // List<int> // ❌ KHÔNG hợp lệ
    List<Integer> nums = Arrays.asList(1, 2, 3, 4);
    // Unboxing khi duyệt
    int sum1 = 0;
    for (int v : nums) sum1 += v;
    // Hoặc mapToInt để dùng primitive stream
    int sum2 = nums.stream().mapToInt(Integer::intValue).sum();
    System.out.println("Sum (for-each) = " + sum1 + ", Sum (mapToInt) = " + sum2);

    // Ví dụ đếm tần suất với Map<String,Integer>
    String[] arr = {"a", "b", "a", "c", "b", "a"};
    Map<String, Integer> freq = new HashMap<>();
    for (String s : arr) {
      freq.put(s, freq.getOrDefault(s, 0) + 1); // auto-unboxing/boxing
    }
    System.out.println("Frequency map: " + freq);

    // contains() dựa vào equals()
    System.out.println("nums.contains(3) ? " + nums.contains(3)); // true
    System.out.println();
  }

  // 7) Parsing & Formatting giữa String và số
  void parsingAndFormatting() {
    System.out.println("=== 7) Parsing & Formatting ===");
    int v = Integer.parseInt("42"); // String -> int
    Integer w = Integer.valueOf("42"); // String -> Integer
    String s1 = String.valueOf(123); // int -> String
    String s2 = w.toString(); // Integer -> String
    System.out.println("parseInt(\"42\") = " + v + ", valueOf(\"42\") = " + w);
    System.out.println("String.valueOf(123) = " + s1 + ", w.toString() = " + s2);
    System.out.println();
  }

  // 8) Primitive streams vs Boxed streams
  void primitiveStreamsVsBoxed() {
    System.out.println("=== 8) Primitive streams vs Boxed streams ===");
    // Primitive stream: không boxing, hiệu quả hơn
    OptionalDouble avg = IntStream.of(1, 2, 3, 4, 5).average();
    avg.ifPresent(a -> System.out.println("IntStream average = " + a));

    // Boxed stream: tốn boxing/unboxing
    double avg2 = Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue).average().orElse(0);
    System.out.println("Stream<Integer> -> mapToInt average = " + avg2);
    System.out.println();
  }

  // 9) Hiệu năng: autoboxing vô tình (boxed Long vs primitive long)
  void performancePitfallAutoboxing() {
    System.out.println("=== 9) Hiệu năng: autoboxing pitfall ===");
    final int N = 2_000_000; // số nhỏ để demo
    long t1 = System.nanoTime();
    long sumPrimitive = 0L;
    for (int i = 0; i < N; i++) sumPrimitive += i; // hoàn toàn primitive
    long t2 = System.nanoTime();

    long t3 = System.nanoTime();
    Long sumBoxed = 0L; // Wrapper!
    for (int i = 0; i < N; i++) sumBoxed += i; // mỗi vòng sẽ boxing/unboxing
    long t4 = System.nanoTime();

    System.out.println("sumPrimitive=" + sumPrimitive + ", time=" + (t2 - t1) / 1_000_000 + " ms");
    System.out.println("sumBoxed=" + sumBoxed + ", time=" + (t4 - t3) / 1_000_000 + " ms");
    System.out.println("=> Dùng primitive trong vòng lặp nặng để tránh autoboxing.");
    System.out.println();
  }
}
