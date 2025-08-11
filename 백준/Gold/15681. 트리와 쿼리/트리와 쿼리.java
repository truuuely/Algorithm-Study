import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] childrenCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int R = Integer.parseInt(st.nextToken()); // 루트 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 수

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[U].add(V);
            tree[V].add(U);
        }

        // 노드 i의 서브트리 개수를 계산해놓기
        visited = new boolean[N + 1];
        visited[R] = true;

        childrenCnt = new int[N + 1];
        getSubtreeCnt(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) { // 10만번
            int U = Integer.parseInt(br.readLine());

            sb.append(childrenCnt[U] + 1).append('\n');
        }

        System.out.println(sb);
    }

    static int getSubtreeCnt(int root) {
        int cnt = 0;

        for (int node : tree[root]) {
            if (!visited[node]) {
                visited[node] = true;
                cnt += 1;
                cnt += getSubtreeCnt(node);
            }
        }

        childrenCnt[root] = cnt;
        return cnt;
    }
}
