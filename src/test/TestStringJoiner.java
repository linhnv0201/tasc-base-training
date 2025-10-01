package test;

import java.security.Signature;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class TestStringJoiner {
  public static void main(String[] args) {
    StringJoiner sj1 = new StringJoiner(", ");
    sj1.add("A").add("B").add("C");

    StringJoiner sj2 = new StringJoiner(", ","[","]");
    sj2.add("1").add("2");

    sj1.merge(sj2).merge(sj1); // ghép sj2 vào sj1
    System.out.println(sj1); // A, B, C, D

    List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
    String result = fruits.stream()
            .collect(Collectors.joining(", ", "[", "]"));
    System.out.println(result); // [Apple, Banana, Cherry]
  }
}
