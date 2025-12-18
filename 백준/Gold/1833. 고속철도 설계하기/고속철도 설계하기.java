import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] root;
    private static int totalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        initRoot();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (j <= i) {
                    continue;
                }

                if (cost > 0) {
                    pq.add(new Edge(i, j, cost));
                } else if (cost < 0) {
                    union(i, j, false);
                    totalCost += -cost;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int newEdgeCnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.u;
            int v = edge.v;
            int cost = edge.cost;

            if (union(u, v, true)) {
                totalCost += cost;
                newEdgeCnt += 1;
                sb.append(u).append(' ').append(v).append('\n');
            }
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(totalCost).append(' ').append(newEdgeCnt).append('\n');
        sb2.append(sb);

        System.out.println(sb2);
    }

    public static void initRoot() {
        root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }
    }

    public static boolean union(int x, int y, boolean isNew) {
        x = find(x);
        y = find(y);

        if (isNew && x == y) {
            // 사이클 발생하면 새로 추가되는건 유니온 하지 말아야 함
            return false;
        }

        root[y] = x;
        return true;
    }

    private static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return root[x] = find(root[x]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v;
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}