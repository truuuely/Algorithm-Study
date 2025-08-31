import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] parent;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        cost = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        kruskal();
    }

    private static void kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.add(new Edge(i, j, cost[i][j]));
            }
        }

        long wSum = 0;
        int cnt = 0;
        // pq 개수: N(N-1)/2
        // MST 간선 개수: N-1개
        while (cnt < N - 1) {
            Edge cur = pq.poll();

            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                wSum += cur.weight;
                cnt += 1;
            }
        }

        System.out.println(wSum);
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 < v2) {
            parent[v2] = v1;
        } else {
            parent[v1] = v2;
        }
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }

        return parent[v] = find(parent[v]); // 경로 단축
    }

    static class Edge implements Comparable<Edge> {
        int v1, v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}