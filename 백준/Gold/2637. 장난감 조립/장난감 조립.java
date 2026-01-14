import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 완제품 번호
        int M = Integer.parseInt(br.readLine());

        int[] indegrees = new int[N + 1];
        graph = new ArrayList[N + 1];
        int[][] basic = new int[N + 1][N + 1]; // basic[i][j] = i -> j 에서 필요한 i의 개수
        int[][] dp = new int[N + 1][N + 1]; // 답

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // X를 만드는 데
            int Y = Integer.parseInt(st.nextToken()); // Y가 K개 필요하다
            int K = Integer.parseInt(st.nextToken()); // 즉, Y(K개) -> X

            graph[Y].add(X);
            basic[Y][X] = K;
            indegrees[X]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                dp[i][i] = 1; // 기본 부품은 1
            }

        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                int required = basic[cur][next];

                for (int i = 1; i <= N; i++) {
                    // next를 만드는 데 필요한 i의 개수 += (cur를 만드는 데 들어간 i의 개수) * (필요한 cur 개수)
                    // 만약 i가 cur 그 자체(기본부품)라면 dp[cur][cur]는 1이므로 1 * required가 됨.
                    dp[i][next] += dp[i][cur] * required;
                }

                indegrees[next]--; // cur -/-> next 연결 끊기
                if (indegrees[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 출력: 하나의 완제품을 조립할 때 기본 부품의 수
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[i][i] == 1) {
                sb.append(i).append(' ').append(dp[i][N]).append('\n');
            }
        }

        System.out.println(sb);
    }
}