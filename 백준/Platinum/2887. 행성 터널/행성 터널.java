import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] parent;

    // 모든 행성을 터널로 연결할 때 드는 최소 비용 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 100_000

        List<List<Point>> lists = new ArrayList<>();
        List<Point> xLists = new ArrayList<>();
        List<Point> yLists = new ArrayList<>();
        List<Point> zLists = new ArrayList<>();
        lists.add(xLists);
        lists.add(yLists);
        lists.add(zLists);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            xLists.add(new Point(x, i)); // 노드 번호 i
            yLists.add(new Point(y, i));
            zLists.add(new Point(z, i));
        }

        Collections.sort(xLists);
        Collections.sort(yLists);
        Collections.sort(zLists);

        // 크루스칼
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int edgeCnt = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (List<Point> points : lists) {
            for (int j = 0; j < points.size() - 1; j++) {
                Point from = points.get(j);
                Point to = points.get(j + 1);
                pq.add(new Edge(from.idx, to.idx, Math.abs(from.p - to.p))); // 노드 i1와 i2를 잇는 간선이 3개씩
            }
        }

        long totalCost = 0;
        while (!pq.isEmpty() && edgeCnt < N - 1) {
            Edge cur = pq.poll();
            int u = cur.u;
            int v = cur.v;
            int cost = cur.cost;

            if (find(u) != find(v)) {
                union(u, v);
                edgeCnt += 1;
                totalCost += cost;
            }
        }

        System.out.println(totalCost);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static class Point implements Comparable<Point> {
        int p, idx;

        public Point(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            return this.p - o.p;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

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