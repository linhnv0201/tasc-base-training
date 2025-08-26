package core.oop;

interface Printable {
  void printInfo();
}

interface Showable {
  void printInfo();
}

// Class implement cả 2 interface
class Document implements Printable, Showable {
  @Override
  public void printInfo() {
    // Chỉ cần override 1 lần cho cả 2 interface
    System.out.println("Document info displayed");
  }
}

// Demo
public class DemoInterfaceOverride {
  public static void main(String[] args) {
    Document doc = new Document();
    doc.printInfo(); // Output: Document info displayed

    // Polymorphism qua interface
    Printable p = doc;
    Showable s = doc;
    p.printInfo(); // Output: Document info displayed
    s.printInfo(); // Output: Document info displayed
  }
}
