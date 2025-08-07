import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] tree;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, dist));
            tree[b].add(new Node(a, dist));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            dfs(a, b, 0);

            sb.append(ans).append('\n');
            ans = 0;
        }

        System.out.println(sb);
    }

    static void dfs(int start, int end, int dist) {
        if (start == end) {
            ans = dist;
            return;
        }

        visited[start] = true;

        for (Node node : tree[start]) {
            if (!visited[node.data] && ans == 0) {
                dfs(node.data, end, dist + node.distance);
            }
        }
    }

    static class Node {
        int data;
        int distance;

        public Node(int data, int distance) {
            this.data = data;
            this.distance = distance;
        }
    }
}

