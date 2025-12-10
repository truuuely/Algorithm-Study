import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Edge>[] graph;
    private static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[n1].add(new Edge(n2, length));
            graph[n2].add(new Edge(n1, length));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] from1 = dijkstra(1);
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);

        // 1 -> v1 -> v2 -> N 계산
        long path1 = 0;
        path1 += (long) from1[v1] + (long) fromV1[v2] + (long) fromV2[N];

        long path2 = 0;
        path2 += (long) from1[v2] + (long) fromV2[v1] + (long) fromV1[N];

        long result = Math.min(path1, path2);
        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);

    }

    private static int[] dijkstra(int start) {
        int[] dp = new int[N + 1]; // start부터 i까지 가는 최단거리
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.length - e2.length);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int end = cur.end;
            int length = cur.length;

            if (length > dp[end]) {
                continue;
            }

            for (Edge next : graph[end]) {
                int newLength = length + next.length;

                if (newLength < dp[next.end]) {
                    dp[next.end] = newLength;
                    pq.add(new Edge(next.end, newLength));
                }
            }
        }

        return dp;
    }

    static class Edge {
        int end;
        int length;

        public Edge(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }
}