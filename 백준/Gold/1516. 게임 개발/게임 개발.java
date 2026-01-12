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
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];
        int[] result = new int[N + 1]; // 선행 건물 짓는 시간 포함한 최종 시간

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }

                graph[n].add(i); // n을 지어야 i를 지을 수 있음
                indegree[i]++;
            }
        }

        topologySort(N, indegree, time, result);
    }

    private static void topologySort(int N, int[] indegree, int[] time, int[] result) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            result[i] = time[i];

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 동시에 짓기 때문에 '가장 오래 걸리는 선행 건물' 기준으로 시간 결정됨
            // result[next] = 기존에 계산된 시간 vs (현재 건물 완료 시간 + 다음 건물 순수 시간) 중 큰 값
            for (int next : graph[cur]) {
                result[next] = Math.max(result[next], result[cur] + time[next]);

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }


}