import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1,000
        int M = Integer.parseInt(st.nextToken()); // 10,000
        int X = Integer.parseInt(st.nextToken()); // 1<=X<=N

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        ArrayList<Edge>[] reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, t));
            reverseGraph[end].add(new Edge(start, t));
        }

        int[] dist1 = dijkstra(X, graph);
        int[] dist2 = dijkstra(X, reverseGraph);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);
    }

    static int[] dijkstra(int X, ArrayList<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int cur = poll.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Edge edge : graph[cur]) {
                    if (!check[edge.end] && dist[edge.end] > dist[cur] + edge.time) {
                        dist[edge.end] = dist[cur] + edge.time;
                        pq.add(new Edge(edge.end, dist[edge.end]));
                    }
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
}
