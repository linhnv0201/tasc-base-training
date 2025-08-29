package collection.listinterface;

// Node không dùng Generics, lưu Object để linh hoạt
class Node {
    Object item;   // giá trị lưu (có thể là bất kỳ object nào)
    Node next;
    Node prev;

    Node(Object item) {
        this.item = item;
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    // thêm vào cuối
    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) { // list rỗng
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // lấy theo index
    public Object get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (index < size / 2) { // duyệt từ đầu
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else { // duyệt từ cuối
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current.item;
    }

    public int size() {
        return size;
    }

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add(5);
    myLinkedList.add("hi");

    for (int i = 0; i < myLinkedList.size(); i++) {
          Object value = myLinkedList.get(i);
          System.out.println(value + " (" + value.getClass().getSimpleName() + ")");
      }
  }
}

