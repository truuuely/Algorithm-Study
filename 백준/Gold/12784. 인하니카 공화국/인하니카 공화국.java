import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static final int D_MAX = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 100

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            tree = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());

                tree[a].add(new Node(b, D));
                tree[b].add(new Node(a, D));
            }

            System.out.println(dfs(1, 1));
        }
    }

    private static int dfs(int cur, int depth) {
        visited[cur] = true;
        boolean isLeaf = true;
        int sum = 0;

        for (Node node : tree[cur]) {
            if (!visited[node.data]) {
                isLeaf = false;
                // cur와 자식노드 node의 비용 비교
                int childCost = dfs(node.data, depth + 1);
                sum += Math.min(node.expense, childCost);
            }
        }

        // 리프 노드는 끊을 수 없음
        if (isLeaf) {
            // 노드 1만 있을 때는 0
            if (depth == 1) {
                return 0;
            }
            return D_MAX + 1;
        }

        return sum;
    }

    static class Node {
        int data;
        int expense;

        public Node(int data, int expense) {
            this.data = data;
            this.expense = expense;
        }
    }
}