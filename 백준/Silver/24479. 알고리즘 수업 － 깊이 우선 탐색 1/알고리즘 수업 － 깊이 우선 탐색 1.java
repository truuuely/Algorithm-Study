import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static TreeSet<Integer>[] tree;
    static int[] visited;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        tree = new TreeSet[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        visited = new int[N + 1];
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {
        visited[cur] = order++;
        for (int node : tree[cur]) {
            if (visited[node] == 0) {
                dfs(node);
            }
        }
    }
}
