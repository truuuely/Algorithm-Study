import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] candies;
    private static int totalPeople, totalCandies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 거리에 있는 아이들 수
        M = Integer.parseInt(st.nextToken()); // 아이들 친구 관계 수
        K = Integer.parseInt(st.nextToken()); // 우는 아이들

        candies = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        List<Group> groups = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                totalPeople = 0;
                totalCandies = 0;
                dfs(i);
                groups.add(new Group(totalPeople, totalCandies));
            }
        }

        int[] dp = new int[K];
        for (Group group : groups) {
            int totalKids = group.totalKids;
            int candySum = group.totalCandies;

            for (int i = K - 1; i >= totalKids; i--) {
                dp[i] = Math.max(dp[i], dp[i - totalKids] + candySum);
            }
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        totalPeople += 1;
        totalCandies += candies[cur];

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static class Group {
        int totalKids, totalCandies;

        public Group(int totalKids, int totalCandies) {
            this.totalKids = totalKids;
            this.totalCandies = totalCandies;
        }
    }
}