import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int pairCnt = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < pairCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int startNode) {
        int cnt = 0;
        visited[startNode] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int node : graph[cur]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
}