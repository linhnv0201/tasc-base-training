package collection.set;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class MyTree {
    Node root;

    // thêm 1 giá trị vào cây
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // gọi thêm từ root
    public void add(int value) {
        root = insert(root, value);
    }

    // duyệt In-order (in ra dãy tăng dần)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // tìm kiếm giá trị
    public boolean search(Node root, int key) {
        if (root == null) return false;
        if (key == root.value) return true;
        if (key < root.value) return search(root.left, key);
        return search(root.right, key);
    }
}

public class MyTree2 {
    public static void main(String[] args) {
        MyTree tree = new MyTree();

        // tự thêm phần tử vào cây
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        // duyệt cây
        System.out.print("In-order traversal: ");
        tree.inorder(tree.root); // sẽ in: 20 30 40 50 60 70 80
        System.out.println();

        // tìm kiếm
        System.out.println("Tìm 40: " + tree.search(tree.root, 40)); // true
        System.out.println("Tìm 90: " + tree.search(tree.root, 90)); // false
    }
}

