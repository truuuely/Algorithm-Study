import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            pq.add(new Edge(0, i, Integer.parseInt(br.readLine())));
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int w = Integer.parseInt(st.nextToken());
                if (j > i) {
                    pq.add(new Edge(i, j, w));
                }
            }
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // node=2, 3/ node=3
        int totalCnt = 0;
        int minCost = 0;
        while (!pq.isEmpty() && totalCnt < N) { // 엣지가 N개가 될 때까지
            Edge cur = pq.poll();
            int to = cur.to;
            int from = cur.from;
            int w = cur.w;

            if (find(to) != find(from)) {
                union(to, from);
                totalCnt += 1;
                minCost += w;
            }
        }

        System.out.println(minCost);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}