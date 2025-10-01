package test;

class Person {
  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

public class TestEqual {
  public static void main(String[] args) {
    Person p1 = new Person("Linh", 25);
    Person p2 = new Person("Linh", 25);
    String s1 = new String("hello");
    String s2 = new String("hello");

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    System.out.println(p1.equals(p2));
  }
}
