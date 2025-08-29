package collection;

import java.util.*;

public class BFSExample {
    private int vertices; // số đỉnh
    private List<List<Integer>> adjList; // danh sách kề

    // Constructor
    public BFSExample(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Thêm cạnh
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // nếu đồ thị vô hướng
    }

    // BFS từ đỉnh start
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSExample g = new BFSExample(6);

        g.addEdge(0, 1); // A-B
        g.addEdge(0, 2); // A-C
        g.addEdge(1, 3); // B-D
        g.addEdge(1, 4); // B-E
        g.addEdge(2, 5); // C-F

        System.out.println("BFS bắt đầu từ đỉnh 0 (A):");
        g.bfs(0); // Output: 0 1 2 3 4 5
    }
}
