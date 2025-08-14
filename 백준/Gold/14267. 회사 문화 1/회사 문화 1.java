import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] compliment;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 회사 직원수
        int m = Integer.parseInt(st.nextToken()); // 최초 칭찬 횟수

        tree = new ArrayList[n + 1];
        compliment = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            tree[parent].add(i);
        }

        for (int i = 0; i < m; i++) { // 10만
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 칭찬받은 직원 번호
            int w = Integer.parseInt(st.nextToken()); // 칭찬 수치

            compliment[num] += w; // 먼저 직원 칭찬을 한다
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(compliment[i]).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        for (int child : tree[idx]) {
            compliment[child] += compliment[idx];
            dfs(child);
        }
    }
}