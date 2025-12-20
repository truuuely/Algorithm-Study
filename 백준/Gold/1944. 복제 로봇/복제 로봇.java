import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dc = {0, 0, -1, 1};
    private static char[][] arr;
    private static List<Point> points; // S, K 위치 저장
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 50
        int M = Integer.parseInt(st.nextToken()); // 250

        arr = new char[N][N];
        points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);

                if (arr[i][j] == 'S') {
                    points.add(0, new Point(i, j, 0));
                } else if (arr[i][j] == 'K'){
                    points.add(new Point(i, j, 0));
                }
            }
        }

        for (int i = 0; i < points.size(); i++) {
            points.get(i).idx = i;
        }

        // 모든 (S, K) 간 거리 구하기
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < points.size(); i++) {
            bfs(points.get(i), pq);
        }

        // 크루스칼
        parent = new int[M + 1];
        for (int i = 0; i <= M; i++) parent[i] = i;

        int totalDist = 0;
        int edgeCount = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalDist += edge.dist;
                edgeCount++;
            }
        }

        // 모든 열쇠와 S가 연결되었는지 확인 (간선이 M개여야 함)
        if (edgeCount == M) {
            System.out.println(totalDist);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(Point start, PriorityQueue<Edge> pq) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new Point(start.r, start.c, 0));
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            // 현 위치가 본인이 아닌 다른 K나 S면 간선 추가
            if (arr[cur.r][cur.c] == 'S' || arr[cur.r][cur.c] == 'K') {
                int targetIdx = findPointIdx(cur.r, cur.c);
                if (targetIdx != start.idx) {
                    // 간선 추가 (start -> target)
                    pq.add(new Edge(start.idx, targetIdx, cur.dist));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && arr[nr][nc] != '1') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, cur.dist + 1));
                }
            }
        }
    }

    private static int findPointIdx(int r, int c) {
        for (Point p : points) {
            if (p.r == r && p.c == c) {
                return p.idx;
            }
        }
        return -1;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootB] = rootA;
    }

    static class Point {
        int r, c, dist, idx;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v;
        int dist;

        public Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}