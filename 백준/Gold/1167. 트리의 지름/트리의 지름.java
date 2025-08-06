import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static Map<Integer, List<Edge>> tree = new HashMap<>();
    static int farNode = 0, farDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            tree.put(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) {
                    break;
                }

                int dist = Integer.parseInt(st.nextToken());
                tree.get(v).add(new Edge(v2, dist));
            }
        }

        visited[1] = true;
        bfs(1);

        Arrays.fill(visited, false);
        visited[farNode] = true;
        bfs(farNode);

        System.out.println(farDist);
    }

    static void bfs(int start) {
        Queue<Edge> q = new ArrayDeque<>();
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (cur.distance > farDist) {
                farNode = cur.linkedTo;
                farDist = cur.distance;
            }

            for (Edge e : tree.get(cur.linkedTo)) {
                if (!visited[e.linkedTo]) {
                    visited[e.linkedTo] = true;
                    q.add(new Edge(e.linkedTo, cur.distance + e.distance));
                }
            }
        }
    }

    static class Edge {
        int linkedTo;
        int distance;

        public Edge(int linkedTo, int distance) {
            this.linkedTo = linkedTo;
            this.distance = distance;
        }
    }
}

