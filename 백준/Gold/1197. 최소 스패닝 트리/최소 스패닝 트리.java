import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    static class Node implements Comparable<Node> {
        int n1;
        int n2;
        int weight;

        public Node(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 10,000
        int e = Integer.parseInt(st.nextToken()); // 100,000

        parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i; // i의 부모를 i로 초기화
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, w));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int n1 = find(node.n1);
            int n2 = find(node.n2);

            if (!isSameParent(n1, n2)) {
                total += node.weight;
                union(node.n1, node.n2);
            }
        }
        System.out.println(total);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}