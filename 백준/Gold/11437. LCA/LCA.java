import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int[] parentOf;
    static Map<Integer, Integer> depthByNode = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수 N개

        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        parentOf = new int[N + 1];
        parentOf[1] = -1;

        dfs(1, 1); // O(n)

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { // 10,000
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 공통 조상 출력
            sb.append(getAncestor(a, b)).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        depthByNode.putIfAbsent(node, depth);

        for (int neighbor : tree.get(node)) {
            if (parentOf[neighbor] == 0) {
                parentOf[neighbor] = node;
                dfs(neighbor, depth + 1);
            }
        }
    }

    static int getAncestor(int node1, int node2) {
        int n1 = node1;
        int n2 = node2;

        while (depthByNode.get(n1) > depthByNode.get(n2)) {
            n1 = parentOf[n1];
        }
        while (depthByNode.get(n1) < depthByNode.get(n2)) {
            n2 = parentOf[n2];
        }

        while (n1 != n2) {
            n1 = parentOf[n1];
            n2 = parentOf[n2];
        }

        return n1;
    }
}

