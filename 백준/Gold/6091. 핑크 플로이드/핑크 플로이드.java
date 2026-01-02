import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = i + 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                pq.add(new Edge(i, j, cost));
            }
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        TreeSet<Integer>[] lists = new TreeSet[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new TreeSet<>();
        }

        int totalCnt = 0;
        while (!pq.isEmpty() && totalCnt < N - 1) {
            Edge edge = pq.poll();

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                totalCnt += 1;
                lists[edge.from].add(edge.to);
                lists[edge.to].add(edge.from);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            TreeSet<Integer> treeSet = lists[i];
            sb.append(treeSet.size()).append(" ");
            for (Integer node : treeSet) {
                sb.append(node).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}