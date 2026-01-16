import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] indegrees = new int[N + 1];
        int[] time = new int[N + 1];
        int[] dp = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int preTaskCnt = Integer.parseInt(st.nextToken());
            if (preTaskCnt == 0) {
                continue;
            }

            for (int j = 0; j < preTaskCnt; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                graph[preTask].add(i);
                indegrees[i]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = time[i];

            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) { // cur -> next
                dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    q.add(next);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, dp[i]);
        }
        System.out.println(maxTime);
    }
}